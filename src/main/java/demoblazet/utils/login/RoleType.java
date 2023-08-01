package demoblazet.utils.login;

public enum RoleType {
    PBL_USERLOGIN("userlogin"), ADMIN("admin"),PARTSSOURCES_USERLOGIN("partssources");

    private String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }


}
