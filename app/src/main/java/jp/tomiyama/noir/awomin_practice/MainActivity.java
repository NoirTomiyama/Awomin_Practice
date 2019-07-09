package jp.tomiyama.noir.awomin_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // カードリソース
    private int[] resources;
    // 0-6までのImageView
    private ImageView[] imageCards;
    // targetImageView
    private ImageView targetView;
    // 選択しているカードの数
    private int chooseNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // linearLayout内のImageView
        imageCards = new ImageView[6];

        int[] imageIds = new int[]{
                R.id.imageView, R.id.imageView2, R.id.imageView3,
                R.id.imageView4, R.id.imageView5, R.id.imageView6
        };

        // 関連付け
        for(int i = 0; i < 6; i++){
            imageCards[i] = findViewById(imageIds[i]);
        }

        targetView = findViewById(R.id.targetView);

        // 0-5までのカードを用意
        resources = new int[]{
                R.drawable.zero,  R.drawable.one,   R.drawable.two,
                R.drawable.three, R.drawable.four,  R.drawable.five,
        };

        for(int i = 0; i < 6; i++) {
            imageCards[i].setImageResource(resources[i]);

            // リスナー登録
            final int finalI = i;
            imageCards[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 選択した数の取得
                    chooseNumber = finalI;
                    targetView.setImageResource(resources[chooseNumber]);
                }
            });
        }
    }
}
