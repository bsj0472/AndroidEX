package com.mrhi2020.ex25customlistview;

public class Member {
    String name;     //"전현무"
    String nation;   //"대한민국"
    int imgId;       // R.drawable.korea

    //생성(new)할때 자동으로 실행되는 메소드
    //생성자 메소드
    public Member(String name, String nation, int imgId){
        this.name= name;
        this.nation= nation;
        this.imgId= imgId;
    }
}
