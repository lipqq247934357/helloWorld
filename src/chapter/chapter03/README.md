# 流程控制

## 分支结构

### if

`if` / `if-else` / `if-else-if`，根据布尔条件选择执行路径。

### switch

`switch (表达式)` 匹配 `case` 常量，配合 `break` 防止穿透；无匹配时走 `default`。支持 `int`、`String` 等类型。

## 循环结构

### for

`for (初始化; 条件; 更新)`，适合已知循环次数的场景。

### for-each

`for (元素类型 变量 : 集合/数组)`，遍历数组或集合。

### while

先判断条件，再执行循环体；条件一开始为 false 则一次也不执行。

### do-while

先执行循环体，再判断条件；至少执行一次。

## 跳转语句

- `break`：跳出当前循环或 `switch`
- `continue`：跳过本次循环，进入下一次

## 运行示例

```bash
cd src/chatper03
javac FlowControlDemo.java
java FlowControlDemo
```
