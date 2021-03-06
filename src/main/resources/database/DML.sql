-- 增删改语句

INSERT INTO `T_user`(`username`, `password`,`type`)
VALUES ('admin', 'admin', 0);

INSERT INTO `T_user`(`username`, `password`, `name`, `sex`, `age`, `class_id`, `type`)
VALUES ('a10001', '123456', '马云', '男', 56, null, 0 ),
       ('a10002', '456789', '马化腾', '男', 49, null, 0),
       ('a10003', '111111', '李彦宏', '男', 52, null, 0),
       ('a10004', '222222', '周鸿祎', '男', 50, null, 0),
       ('t10005', 't12345', '俞敏洪', '男', 58, null, 1),
       ('t10006', 't45678', '雷军', '男', 51, null, 1),
       ('t10007', 't11111', '任正非', '男', 76, null, 1),
       ('t10008', 't22222', '史蒂夫·乔布斯', '男', 56, null, 1),
       ('t10009', 't33333', '卢伟冰', '男', 45, null, 1),
       ('t10010', 't44444', '张平安', '男', 48, null, 1),
       ('t10011', 't55555', '陈明永', '男', 51, null, 1),
       ('s10012', 's66666', '景天', '男', 20, 1, 2),
       ('s10013', 's77777', '唐雪见', '女', 19, 1, 2),
       ('s10014', 's88888', '徐长卿', '男', 27, 1, 2),
       ('s10015', 's99999', '紫萱', '女', 25, 1, 2),
       ('s10016', 's23456', '龙葵', '女', 18, 1, 2),
       ('s10017', 's59357', '重楼', '男', 30, 2, 2),
       ('s10018', 's89456', '徐茂山', '男', 21, 2, 2),
       ('s10019', 's56123', '清微', '男', 70, 2, 2),
       ('s10020', 's47258', '邪剑仙', '男', 53, 2, 2),
       ('s10021', 's12345', '泽田纲吉', '男', 14, 2, 2),
       ('s10022', 's12345', '狱寺隼人', '男', 14, 2, 2),
       ('s10023', 's12345', '山本武', '男', 14, 2, 2 ),
       ('s10024', 's12345', '蓝波', '男',5, 2, 2),
       ('s10025', 's12345', '笹川了平', '男', 15, 2, 2),
       ('s10026', 's12345', '云雀恭弥', '男', 15, 2, 2),
       ('s10027', 's12345', '库洛姆·髑髅', '女', 13, 2, 2),
       ('s10028', 's12345', '笹川京子', '女', 14, 2, 2),
       ('s10029', 's12345', '三浦春', '女', 14, 2, 2),
       ('s10030', 's12345', '碧洋琪', '女', 17, 2, 2),
       ('s10031', 's12345', '迪诺', '男', 22, 2, 2),
       ('s10032', 's12345', '风太', '男', 9, 2, 2),
       ('s10033', 's12345', 'XANXUS', '男', 24, 2, 2),
       ('s10034', 's12345', '斯贝尔比·斯夸罗', '男', 22, 2, 2),
       ('s10035', 's12345', '贝尔菲戈尔', '男', 16, 2, 2),
       ('s10036', 's12345', '玛蒙', '男', 5, 2, 2),
       ('s10037', 's12345', '列维·亚·坦', '男', 23, 2, 2),
       ('s10038', 's12345', '路斯利亚', '男', 25, 2, 2),
       ('s10039', 's12345', '哥拉·莫斯卡', '无', 0, 2, 2),
       ('s10040', 's12345', '弗兰', '男', 14, 2, 2),
       ('s10041', 's12345', '入江正一', '男', 14, 2, 2),
       ('s10042', 's12345', '斯帕纳', '男', 14, 2, 2),
       ('s10043', 's12345', '强尼二', '男', 14, 2, 2),
       ('s10044', 's12345', '白兰', '男', 24, 2, 2),
       ('s10045', 's12345', '石榴', '男', 25, 2, 2),
       ('s10046', 's12345', '桔梗', '男', 25, 2, 2),
       ('s10047', 's12345', '铃兰', '男', 24, 2, 2),
       ('s10048', 's12345', '狼毒', '男', 25, 2, 2),
       ('s10049', 's12345', '雏菊', '男', 25, 2, 2),
       ('s10050', 's12345', 'GHOST', '男', 24, 2, 2);

INSERT INTO `T_homework`(`teacher_id`, `title`, `describe`, `class_id`, `end_time`, `attachment_title`, `attachment_url`)
VALUES(6, '语文', '大学一年级', 1, '2020-12-15', '课后作业', 'E://11.txt'),
      (6, '语文', '大学一年级', 2, '2020-12-15', '课后作业', 'E://11.txt'),
      (6, '语文', '大学一年级', 3, '2020-12-15', '课后作业', 'E://11.txt'),
      (7, '数学', '大学一年级', 1, '2020-12-15', '课后作业', 'E://22.txt'),
      (7, '数学', '大学一年级', 2, '2020-12-15', '课后作业', 'E://22.txt'),
      (7, '数学', '大学一年级', 3, '2020-12-15', '课后作业', 'E://22.txt'),
      (8, '英语', '大学一年级', 1, '2020-12-15', '课后作业', 'E://33.txt'),
      (8, '英语', '大学一年级', 2, '2020-12-15', '课后作业', 'E://33.txt'),
      (8, '英语', '大学一年级', 3, '2020-12-15', '课后作业', 'E://33.txt');

INSERT INTO `T_student_homework`(`hw_id`, `s_id`, `title`, `describe`, `status`, `review_content`,`review_time`,`attachment_title`, `attachment_url`)
VALUES(1, 13, '语文', '大学一年级', true, '很好', '2020-12-16', '语文课后作业', 'E://1.txt'),
      (1, 14, '语文', '大学一年级', false, null, null, '语文课后作业', 'E://11.txt'),
      (1, 15, '语文', '大学一年级', true, '还行', '2020-12-16', '语文课后作业', 'E://22.txt'),
      (4, 13, '数学', '大学一年级', true, '不错', '2020-12-17', '数学课后作业', 'E://1.txt'),
      (2, 14, '数学', '大学一年级', true, '一般', '2020-12-17', '数学课后作业', 'E://1.txt'),
      (2, 15, '数学', '大学一年级', false, null, null, '数学课后作业', 'E://22.txt'),
      (7, 13, '英语', '大学一年级', false, null, null, '英语课后作业', 'E://1.txt'),
      (3, 14, '英语', '大学一年级', true, '继续努力', '2020-12-18', '英语课后作业', 'E://11.txt'),
      (3, 15, '英语', '大学一年级', true, '加油', '2020-12-18', '英语课后作业', 'E://22.txt');

INSERT INTO `T_class`(`classNo`, `className`)
VALUES('c1','a-1'),
      ('c2','a-2'),
      ('c3','a-3');

INSERT INTO `T_notice`(`title`, `content`, `create_time`)
VALUES('通知', '请同学按时提交作业,作业的情况将会被记录期末测评', '2020-12-15'),
      ('通知', '请老师能够及时给学生批改作业，并且给出相对意见', '2020-12-14');

INSERT INTO `T_message`(`title`, `content`, `create_time`)
VALUES('雷军老师你好,我是景天', '关于今天英语阅读理解我还有点不懂,希望可以重新讲一遍', '2020-12-19'),
      ('景天同学你好,我是雷军老师', '英语阅读理解，明天上课我会再讲一遍，不用担心', '2020-12-19'),
      ('任正非老师你好,我是重楼', '关于今天数学的计算题,解题思路能否给我讲一下', '2020-12-19'),
      ('重楼同学你好,我是任正非老师', '数学计算题的思路是这样的:……', '2020-12-19');