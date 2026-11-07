import java.util.NoSuchElementException;

import edxbackup.ArrayList;

public class ArrayListTester {
    public static void main(String[] args) {
        System.out.println("=== 開始測試 ArrayList ===");
        ArrayList<String> list = new ArrayList<>();

        // 1. 測試初始狀態
        assert list.size() == 0 : "錯誤：初始大小應為 0";
        System.out.println("✓ 初始狀態測試通過");

        // 2. 測試 addToBack 與自動擴容 (Initial Capacity 是 9，塞到第 10 個會觸發 resize)
        System.out.println("正在測試 addToBack 與 resize...");
        for (int i = 1; i <= 12; i++) {
            list.addToBack("Item " + i);
        }
        assert list.size() == 12 : "錯誤：size 應為 12";
        assert list.getBackingArray().length >= 12 : "錯誤：底層陣列未正確擴容";
        System.out.println("✓ addToBack 與 resize 測試通過");

        // 3. 測試 removeFromBack
        String backItem = list.removeFromBack();
        assert backItem.equals("Item 12") : "錯誤：removeFromBack 應回傳最後一個元素";
        assert list.size() == 11 : "錯誤：移除後 size 應為 11";
        System.out.println("✓ removeFromBack 測試通過");

        // 4. 測試 addToFront
        list.addToFront("First Item");
        assert list.size() == 12 : "錯誤：addToFront 後 size 應為 12";
        assert list.getBackingArray()[0].equals("First Item") : "錯誤：第一個元素應為 First Item";
        System.out.println("✓ addToFront 測試通過");

        // 5. 測試 removeFromFront
        String frontItem = list.removeFromFront();
        assert frontItem.equals("First Item") : "錯誤：removeFromFront 應回傳第一個元素";
        System.out.println("✓ removeFromFront 測試通過");

        // 6. 測試例外狀況 (Exceptions)
        System.out.println("正在測試例外狀況...");
        
        // 6.1 測試加入 null 是否拋出 IllegalArgumentException
        boolean nullArgThrown = false;
        try {
            list.addToBack(null);
        } catch (IllegalArgumentException e) {
            nullArgThrown = true;
        }
        assert nullArgThrown : "錯誤：加入 null 應該拋出 IllegalArgumentException";

        // 6.2 測試空清單移除是否拋出 NoSuchElementException
        ArrayList<String> emptyList = new ArrayList<>();
        boolean noSuchElemThrown = false;
        try {
            emptyList.removeFromFront();
        } catch (NoSuchElementException e) {
            noSuchElemThrown = true;
        }
        assert noSuchElemThrown : "錯誤：空清單移除應拋出 NoSuchElementException";
        
        System.out.println("✓ 例外狀況測試通過");

        System.out.println("\n🎉 太棒了！所有本地測試都順利通過！");
    }
}