# mybatis-plus-used
mybatis-plus使用

#### first-used

1. 创建数据库mybatis-plus
2. 导入表结构

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
`uid` bigint(20) NOT NULL AUTO_INCREMENT,
`user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`age` int(11) NULL DEFAULT NULL,
`email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`is_deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0,
`create_time` datetime(0) NULL DEFAULT NULL,
`update_time` datetime(0) NULL DEFAULT NULL,
`version` int(255) NULL DEFAULT NULL,
PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1553449097266995218 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

##### 雪花算法

水平分表：将一张表中的数据，分到几个表里面

1. 主键自增：1-999999 放到表1中，1000000-1999999存到表2中，可能分布不均匀
2. 取模，根据模的值，存放对应编号的值，初始表数量的决定，分布均匀。扩充表很麻烦，所有数据都要重新分布。
3. 雪花算法，推特分布式主键生成算法，不同表的主键的不重复性，以及相同表的主键的有序性，64bit，整体上按照时间自增排序，整个分布式系统不会产生ID碰撞，并且效率高

##### @TableLogic 逻辑删除

* 物理删除：真实删除，将对应的数据从数据库中删除，查询不到
* 逻辑删除：假删除，将对应数据中代表是否被删除字段的状态修改为被删除状态，之后在数据库中仍旧能看到此条数据
* 使用场景：数据恢复

默认0是未删除，1已删除

##### 条件构造器

* Wrapper：条件构造抽象类，最顶端父类
    
* AbstractWrapper：用于查询条件封装，生成sql的where条件
* QueryWrapper：查询条件封装
* UpdateWrapper：Update条件封装
* AbstractLambdaWrapper：使用Lambda语法
* LambdaQueryWrapper：用于Lambda语法使用的查询Wrapper
* LambdaUpdateWrapper：Lambda更新封装Wrapper

##### 乐观锁和悲观锁

> 通过version来实现

如果是乐观锁，小王保存价格之前，会检索价格是否被人修改了，如果被修改过，则重新取出的被修改后的价格，150元，这样会将120元存入数据库

> 关闭自动提交，select ... for update 行锁

如果是悲观锁，小李取出数据后，小王只能等小李操作完之后，才能对价格进行操作，也会保证最终的价格。




