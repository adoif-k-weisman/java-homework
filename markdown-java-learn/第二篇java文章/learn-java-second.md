# 学习java

## java注释写法

注释用/**开始，*/作为结尾。

@author 作者

@version 版本

@param arr 传入的值 （arr是方法参数的名称，“传入的值”是对参数名的说明）

@return 返回的值 （返回什么这里填写什么，“返回的值”是对返回值的说明） 直接上例子，现在能看懂即可。

```java

/**
 * 求一个int数组的最小值
 //* @param arr 传入一个int数组
 * @return 返回一个int数值
 */
//我至今都不会明白，为何idea连我的markdown代码块都要强行要求
class NiuMa {
    public static int min(int[] arr) {
        int j = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (j > arr[i]) {
                j = arr[i];
            }
        }
        return j;
    }
}
```
