package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author �˿���
 * @date 2021��06��19�� 21:39
 */
public class matchPlay {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("��");
        nameList.add("��");
        nameList.add("��");
        nameList.add("��");
        nameList.add("ݮ");
        nameList.add("��");
        nameList.add("��");
        nameList.add("��");

        List<String> placeList = new ArrayList<>();
        placeList.add("��ɭ����");
        placeList.add("�ڲ�ԭ��");
        placeList.add("�ڲ�����");
        placeList.add("��������");
        placeList.add("�ڹű���");

        List<String> gameList = new ArrayList<>();
        gameList.add("������Ϸ");
        gameList.add("��ɫ����");
        gameList.add("�ݹ�ķ����");
        gameList.add("�������");
        gameList.add("������ս");
        gameList.add("���ƹ���");
        gameList.add("�㻭�Ҳ�");


        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int place = random.nextInt(placeList.size());
        int name = random.nextInt(nameList.size());
        int game = random.nextInt(gameList.size());
        sb.append(nameList.get(name));
        sb.append(placeList.get(place));
        sb.append("��");
        sb.append(gameList.get(game));
        System.out.println(sb);
    }

}
