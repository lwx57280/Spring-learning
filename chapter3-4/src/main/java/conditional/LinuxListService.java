package conditional;
/**
 * Linux下所要创建Bean类
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
