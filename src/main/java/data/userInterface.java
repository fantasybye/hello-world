package data;

public interface userInterface {
	public int judgeLogin(String userName,String pwd);////判断用户登录，0成功，-1用户名错误，-2密码错误
	public int addUser(String name,String psw,boolean is);////添加新用户，0成功，-1用户名已存在，-2密码少于六位
}
