package com.spring.test.dto;

public class UserDto {
    private String name;
    private String email;
    private String password;

    private UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{"
                + "name='" + name + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + '}';
    }

    public static Builder newBuilder() {
        return new UserDto().new Builder();
    }

    public class Builder {
        private UserDto userDto;

        public Builder() {
            userDto = new UserDto();
        }

        public Builder setName(String name) {
            userDto.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            userDto.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            userDto.password = password;
            return this;
        }

        public UserDto build() {
            return userDto;
        }

    }
}
