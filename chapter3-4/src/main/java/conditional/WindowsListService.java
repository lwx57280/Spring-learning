package conditional;

/**
 * Windows下所要创建的Bean类
 */
public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }
}
