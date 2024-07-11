# RPCFramwork

---
基于java开发的简易RPC框架
---

目前完成接口Mock的开发，接下来完成序列化器宇SPI   
目前项目结构   
1. provider作为服务器提供服务  
2. consumer使用provider的服务  
3. common文件将provider与consumer共同含有的部分单独作为一个文件,service部分通过反射注入的方式实现函数的不同实现（有无mock）  
4. rpcframework文件实现了整体rpc框架，这个rpc框架承担了服务器的运行、消息的转发、服务的注入等功能。绝大部分内容（各种工具函数）都在rcp框架文件中，消费者与提供者仅关注提供的函数即可，不用管内部实现。
5. 在读rpcframework文件的时候直接跳转读即可，没有很多重载函数，线性跳转即可

---
# 测试说明
本次Mock功能的测试：
先启动生产者
修改消费者resource文件中的配置文件中mock字段
启动消费者
---

# 提交说明
每次代码的提交确保项目可以直接运行
