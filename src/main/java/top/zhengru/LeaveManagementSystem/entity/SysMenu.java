package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
public class SysMenu implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String path;

    /**
     * 
     */
    private String component;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String iconCls;

    private Meta meta;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 
     */
    private Integer enabled;

    private List<Meta> children;
    private List<SysRole> roles;

    public SysMenu() {
    }

    public SysMenu(Integer id, String url, String path, String component, String name, String iconCls, Meta meta, Integer parentId, Integer enabled, List<Meta> children, List<SysRole> roles) {
        this.id = id;
        this.url = url;
        this.path = path;
        this.component = component;
        this.name = name;
        this.iconCls = iconCls;
        this.meta = meta;
        this.parentId = parentId;
        this.enabled = enabled;
        this.children = children;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Meta> getChildren() {
        return children;
    }

    public void setChildren(List<Meta> children) {
        this.children = children;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", meta=" + meta +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", children=" + children +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return Objects.equals(id, sysMenu.id) && Objects.equals(url, sysMenu.url) && Objects.equals(path, sysMenu.path) && Objects.equals(component, sysMenu.component) && Objects.equals(name, sysMenu.name) && Objects.equals(iconCls, sysMenu.iconCls) && Objects.equals(meta, sysMenu.meta) && Objects.equals(parentId, sysMenu.parentId) && Objects.equals(enabled, sysMenu.enabled) && Objects.equals(children, sysMenu.children) && Objects.equals(roles, sysMenu.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, path, component, name, iconCls, meta, parentId, enabled, children, roles);
    }
}