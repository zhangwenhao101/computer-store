package com.zwh.store.controller;

import com.zwh.store.controller.ex.*;
import com.zwh.store.entity.User;
import com.zwh.store.service.IUserService;
import com.zwh.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zwh
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping(value = "login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = iUserService.login(username, password);
        //向session数据中完成数据绑定
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping(value = "change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping(value = "get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        User data = iUserService.getByUid(uid);
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping(value = "change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changeInfo(uid, username, user);
        return new JsonResult<Void>(OK);
    }

    /**
     * 设置上传文件最大值
     */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /**
     * 限制上传文件的类型
     */
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("jpeg");
        AVATAR_TYPE.add("images/png");
        AVATAR_TYPE.add("images/bmp");
        AVATAR_TYPE.add("images/gif");
    }

    /**
     * @param session
     * @param file
     * @return
     */
    @RequestMapping(value = "change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file) {
        //判断文件是否为null
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件大小超出限制");
        }
        //判断文件类型是否符合规范
        if (AVATAR_TYPE.contains(file.getContentType())) {
            throw new FileTypeException("文件类型不支持");
        }
        //
        String path = session.getServletContext().getRealPath("/upload");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

        //获取文件名，并使用UUID作为新文件名
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        File dest = new File(dir, filename);
        //将file写入到dest
        try {
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        //返回头像路径
        String avatar = "/upload/" + filename;
        iUserService.changeAvatar(uid, avatar, username);
        return new JsonResult<>(OK,avatar);
    }



}
