**所有的传入的 Bean 类对象的 id 均为 null**

**P 是泛型**

**如果可以的话所有的增删查改都写出来, 下面可能每列全**

### UserService
- `getInstance :: () -> UserService`
- `add :: (User user) -> Boolean`
- `remove :: (Integer id) -> Boolean`
- `getUserById :: (Integer id) -> User`
- `getUserByUsername :: (String username) -> User`
- `listTeacherByPage :: () -> List<User>`
- `listStudentByPage :: () -> List<User>`
- `update :: (Integer userId, String PropertyName, P propertyValue) -> Boolean`
- `login :: (String username, String password) -> Boolean`

### ClassService
- `getInstance :: () -> ClassService`
- `add :: (Clazz clazz) -> Boolean`
- `remove :: (Integer id) -> Boolean`
- `listClasses :: () -> List<Clazz>`

### HomeworkService
- `getInstance :: () -> HomeworkService`
- `add :: (Homework homework) -> Boolean`
- `remove :: (Integer homeworkId) -> Boolean`
- `listHomeworkByClassId :: (Integer classId) -> List<Homework>`
- `listHomeworkByTeacherId :: (Integer teacherId) -> List<Homework>`
- `update :: (Integer homeworkId, String PropertyName, P propertyValue) -> Boolean`

### StudentHomework
- `getInstance :: () -> StudentHomework`
- `add :: (StudentHomework studentHomework) -> Boolean`
- `remove :: (Integer studentHomeworkId) -> Boolean`
- `listHomeworkByStudentId :: (Integer studentId) -> List<StudentHomework>`
- `listHomeworkByTeacherId :: (Integer teacherId) -> List<StudentHomework>`
- `update :: (Integer studentHomeworkId, String PropertyName, P propertyValue) -> Boolean`

### MessageService
- `getInstance :: () -> MessageService`
- `add :: (Message message) -> Boolean`
- `remove :: (Integer id) -> Boolean`
- `listMessages :: () -> List<Message>`

### NoticeService
- `getInstance :: () -> NoticeService`
- `add :: (Notice notice) -> Boolean`
- `remove :: (Integer id) -> Boolean`
- `listNotices :: () -> List<Notice>`
- `update :: (Integer noticeId, String PropertyName, P propertyValue) -> Boolean`