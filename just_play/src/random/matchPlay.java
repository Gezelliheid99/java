package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 潘俊杰
 * @date 2021年06月19日 21:39
 */
public class matchPlay {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("茸");
        nameList.add("茶");
        nameList.add("布");
        nameList.add("橘");
        nameList.add("莓");
        nameList.add("米");
        nameList.add("休");
        nameList.add("冰");

        List<String> placeList = new ArrayList<>();
        placeList.add("在森林里");
        placeList.add("在草原上");
        placeList.add("在餐厅里");
        placeList.add("在民宿里");
        placeList.add("在古堡里");

        List<String> gameList = new ArrayList<>();
        gameList.add("国王游戏");
        gameList.add("角色互换");
        gameList.add("演哈姆雷特");
        gameList.add("起火做饭");
        gameList.add("社死挑战");
        gameList.add("慈善公演");
        gameList.add("你画我猜");


        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int place = random.nextInt(placeList.size());
        int name = random.nextInt(nameList.size());
        int game = random.nextInt(gameList.size());
        sb.append(nameList.get(name));
        sb.append(placeList.get(place));
        sb.append("玩");
        sb.append(gameList.get(game));
        System.out.println(sb);
    }

}
