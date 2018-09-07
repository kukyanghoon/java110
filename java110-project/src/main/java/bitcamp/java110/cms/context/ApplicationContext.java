package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;


/*IoC : Inversion of Control :코드 흐름의 역행    
 * 1) EventListner
 * 2) Dependancy Infection (DI) : 의존객체 주입/ 의존성 주입 본인이 아닌 다른곳에서 주입됨
 * 
 * IoC 컨테이너 =  Bean    Container  +   DI
 *             object     pool
 * 
 * 
 * */
public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();

    public ApplicationContext(String packageName) throws Exception
    {
        //패키지 이름을 파일 경로로 바꾼다.
        String path = packageName.replace(".","/");
        //System.out.println(path);
        //패키지 경로를 가지고 전체 파일 경로를 알아낸다
        File file = Resources.getResourceAsFile(path);

        //패키지 폴더에 들어있는 파일 목록을 알아낸다.
        findClass(file, path);

        System.out.println(file.getAbsolutePath());
        //1)인스턴스 생성
        //해당 패키지에 있는 클래스를 찾아서 인스턴스를 생성한 후에
        //objPool에 보관한다
    }


    public Object getBean(String name)
    {
        //objPool에서 주어진 이름의 객체를 찾아 리턴한다.
        return objPool.get(name);
    }

    public void findClass(File path, String packagePath) throws Exception{
        File[] files = path.listFiles();
        for(File file : files)
        {
            if(file.isDirectory()) {
                findClass(file, packagePath +"/"+file.getName());
            }else {

                String className = (packagePath+"/"+file.getName())
                        .replace("/", ".")
                        .replace(".class", "");
                //1)클래스 이름을 가지고  .class파일을 찾아 메모리에 로딩한다.
                Class<?> clazz = Class.forName(className);
                //=>인터페이스인 경우 무시한다.
                if(clazz.isInterface())
                {
                    continue;
                }
                try {
                    //2)로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                    //=>먼저 해당 클래스에 생성자 정보를 얻는다.

                    Constructor<?> constructor = clazz.getConstructor();
                    //=>생성자를 가지고 인스턴스를 생성한다.
                    Object instance = constructor.newInstance();
                    
                    //=>이름으로 인스턴스의 필드를 찾는다.
                    Field field = clazz.getField("name");
                    
                    //=>"name"필드의 값을 꺼낸다.
                    Object name = field.get(instance);
                    //System.out.println(clazz.getName()+"==>"+name);
                    
                    //=>"name"필드의 값으로 인스턴스를 objPoll에 저장한다.
                    objPool.put((String) name, instance);
                    
                    //clazz.newInstance();
                }catch(Exception e)
                {
                    System.out.printf("%s 클래스는 기본생성자가없다", clazz.getName());
                    System.out.println();
                }
            }

        }
    }

}
