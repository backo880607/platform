package com.pisces.platform.token.login;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 调用 `StpUtil.login()` 时的 [配置参数 Model ]
 *
 * @author jason
 * @date 2023/06/15
 */
@Getter
@Setter
public class SaLoginModel {

    /**
     * 此次登录的客户端设备类型
     */
    public String device;

    /**
     * 是否为持久Cookie（临时Cookie在浏览器关闭时会自动删除，持久Cookie在重新打开后依然存在）
     */
    public Boolean isLastingCookie = true;

    /**
     * 指定此次登录token的有效期, 单位:秒 （如未指定，自动取全局配置的timeout值）
     */
    public Integer timeout;

    /**
     * 扩展信息（只在jwt模式下生效）
     */
    public Map<String, Object> extraData;

    /**
     * 预定Token（预定本次登录生成的Token值）
     */
    public String token;

    public SaLoginModel() {

    }

    public SaLoginModel(int timeout) {
        this.timeout = timeout;
    }

    public SaLoginModel(String device) {
        this.device = device;
    }


    /**
     * 写入扩展数据（只在jwt模式下生效）
     *
     * @param key   键
     * @param value 值
     * @return 对象自身
     */
    public SaLoginModel setExtra(String key, Object value) {
        if (this.extraData == null) {
            this.extraData = new LinkedHashMap<>();
        }
        this.extraData.put(key, value);
        return this;
    }

    /**
     * 获取扩展数据（只在jwt模式下生效）
     *
     * @param key 键
     * @return 扩展数据的值
     */
    public Object getExtra(String key) {
        if (this.extraData == null) {
            return null;
        }
        return this.extraData.get(key);
    }

    /**
     * 判断是否设置了扩展数据
     *
     * @return /
     */
    public boolean isSetExtraData() {
        return extraData != null && extraData.size() != 0;
    }
}
