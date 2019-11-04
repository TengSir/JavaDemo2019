package com.oracle.java.advance.t5;
/**
 * 供体人类型，该类型存储供体对象的信息
 */
public class Provider {
    private int age;
    private String name;
    private String sex;
    private String guominshi;
    private String bloodType;

    public Provider() {
    }

    public Provider(int age, String name, String sex, String guominshi, String bloodType) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.guominshi = guominshi;
        this.bloodType = bloodType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGuominshi() {
        return guominshi;
    }

    public void setGuominshi(String guominshi) {
        this.guominshi = guominshi;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * 心脏类型，该类型存储捐赠的心脏对象过的信息
     */
    public class Heart{
            private float weight;
            private int xinlv;
            private String left;
            private String right;

        public Heart() {
        }

        public Heart(float weight, int xinlv, String left, String right) {
            this.weight = weight;
            this.xinlv = xinlv;
            this.left = left;
            this.right = right;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public int getXinlv() {
            return xinlv;
        }

        public void setXinlv(int xinlv) {
            this.xinlv = xinlv;
        }

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
        }
    }
}
