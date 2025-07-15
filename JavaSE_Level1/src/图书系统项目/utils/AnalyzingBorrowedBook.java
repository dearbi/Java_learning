package 图书系统项目.utils;

import com.bit.utils.FileUtils;
import 图书系统项目.book.PairOfUidAndBookId;

import java.io.IOException;

public class AnalyzingBorrowedBook {
    public PairOfUidAndBookId[] loadObject(String filename) throws IOException {
//从⽂件读取数据
        String content = FileUtils.readFile(filename);
        if (content == null || content.isEmpty()) {
            System.out.println("已借阅书籍列表⽆数据，表⽰没有⽤⼾借阅过书籍");
            return null;
        }
        String[] JsonStrings = content.split("\n");
        PairOfUidAndBookId[] pairOfUidAndBookIds = new PairOfUidAndBookId[JsonStrings.length];
        for(int i = 0;i<JsonStrings.length;i++)
        {
            PairOfUidAndBookId pairOfUidAndBookId = new PairOfUidAndBookId();
            String[] uidAndBookIds = JsonStrings[i].split(",");
            pairOfUidAndBookId.setUserId(Integer.parseInt(uidAndBookIds[0]));
            pairOfUidAndBookId.setBookId(Integer.parseInt(uidAndBookIds[1]));
            pairOfUidAndBookIds[i] = pairOfUidAndBookId;
        }
        return pairOfUidAndBookIds;
    }
    public void storeObject(PairOfUidAndBookId[] pairOfUidAndBookIds, String
            filename) throws IOException {
//先遍历pairOfUidAndBookIds数组当中不为空的数据多少个?
        int booksUseLen = 0;
        for (int i = 0; i < pairOfUidAndBookIds.length; i++) {
            if(pairOfUidAndBookIds[i] != null) {
                booksUseLen++;
            }
        }
        StringBuilder jsonArray = new StringBuilder();
        for (int i = 0; i < booksUseLen; i++) {
            if(pairOfUidAndBookIds[i] != null) {
                jsonArray.append(pairOfUidAndBookIds[i].toJson());
                if (i != booksUseLen-1) {
                    jsonArray.append("\n");
                }
            }
        }
        FileUtils.writeFile(jsonArray.toString(),filename);/* */
    }

}

