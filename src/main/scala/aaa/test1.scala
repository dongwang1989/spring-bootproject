package aaa

import net.bytebuddy.implementation.bind.annotation.Super


object test1 {
  def main(args: Array[String]) {
    println("Hello, world!") // 输出 Hello World
    var z = new Array[String](3)
    z(0) = "Runoob"; z(1) = "Baidu"; z(4/2) = "Google"
    var myList = Array(1.9, "fhfht", 3.4, 3.5)
    for(i<-0 to myList.length-1){
      print(myList(i));
    }
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil));
    for(i<-0 to site.length-1){
      print(site(i)+"/r");
    }

    //var a="";
    //var b :Int=1;
    //val aa = "";
    //lazy  val aaa="";
    //Unit相当于void Nothing相当于其他类型的子类 表示没有值比如说List不指定类型
    //any所有类型的超类anyref所有引用类型的超类anyval所有值类型的超类null空值或是
    //空引用
  }



}
