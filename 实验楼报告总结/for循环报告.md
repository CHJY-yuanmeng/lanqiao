# 案例代码
```java
public class Test{
    static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    public static void main(String args[]){
        int i=0;
        for(foo('A');foo('B')&&(i<2);foo('C')){
            i++;
            foo('D');
        }
    }
}
```

# 运行结果与总结


- 结果  
A  
B  
D  
C  
B  
D  
C  
B  
- 总结  
已知：  
```java
for（执行式1;执行式2;执行式3)
{
执行式4;
}
```
 - 执行顺序：执行式1->执行式2->执行式4->执行式3->执行式2->执行式4->执行式3.......  
案例代码解读：  
有方法foo，每次执行foo都会输出一个字符到控制台。
根据执行顺序，执行式1：foo('A')只会被执行一次，所以输出 **A**  
执行式2：foo('B')&&(i<2)接着被执行，输出 **B**  
根据判断执行式2成立，继续执行式4：i++;foo('D');输出 **D**  
执行式3：foo('C')，输出 **C**  
依次循环



