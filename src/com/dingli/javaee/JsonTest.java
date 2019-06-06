package com.dingli.javaee;

import com.dingli.javaee.bean.param.StuParam;
import com.dingli.javaee.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        String json = "{\"name\":\"解放路的数据\",\"start\":\"\",end\":\"\"}";

        // 把json字符串转换为 StudentParam 对象
        StuParam sp = JsonUtil.toBean(json,StuParam.class);
        System.out.println(sp);

        System.out.println("-----------------------");
        // 转换成Map<string,Object>
        Map<String,Object> map = JsonUtil.toGenericBean(json,new TypeReference<Map<String,Object>>(){});
        System.out.println(map.get("start"));
    }

//    static class StudentParam{
//        private String name;
//        // 获取参数时，参数应该使用包装类型，因为原生类型没有null
//        private Integer start;
//        private Integer end;
//
//        public StudentParam() {
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Integer getStart() {
//            return start;
//        }
//
//        public void setStart(Integer start) {
//            this.start = start;
//        }
//
//        public Integer getEnd() {
//            return end;
//        }
//
//        public void setEnd(Integer end) {
//            this.end = end;
//        }
//    }
}
