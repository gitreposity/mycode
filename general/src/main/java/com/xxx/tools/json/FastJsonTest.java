package com.xxx.tools.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class FastJsonTest {


    public static void main(String[] args) {

        Stu stu = new Stu();
        stu.setId(1);
        stu.setName("kate");
        stu.setGame(new Stu.Game(1,"lol"));

        String stuStr = JSON.toJSONString(stu);

        JSONObject jsonObject = JSON.parseObject(stuStr);

        System.out.println(jsonObject.get("game"));

        System.out.println(JSONPath.eval(jsonObject,"$.game"));;
//        System.out.println(stuGame);


        Stu.Game stuGame = JSON.parseObject(jsonObject.get("game").toString(),Stu.Game.class);
        System.out.println(stuGame);
    }

    @Data
    @NoArgsConstructor
    static class Stu implements Serializable{
        private Integer id;

        private String Name;

        private Game game;

        @Data
        @NoArgsConstructor
        static class Game implements Serializable{
            private Integer gameId;

            private String gameName;

            public Game(Integer gameId, String gameName) {
                this.gameId = gameId;
                this.gameName = gameName;
            }
        }


    }
}
