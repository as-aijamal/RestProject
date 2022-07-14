package peaksoft.enumPackage;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    TEACHER,
    STUDENT;


    @Override
    public String getAuthority(){
        return this.name();
    }

}
