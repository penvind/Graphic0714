package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.graphic0714.R;

/**
 * Created by Administrator on 2015-07-14.
 */
public class GameView extends View {
    Bitmap ship_bitmap;
    private int posX;
    private int posY=250;
    Paint paint;
    // 조이스틱, 총알 버튼의 크기
    RectF[] control = new RectF[5];
    int controlWidth = 100;
    int controlHeight = 100;


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.retro);
        ship_bitmap=Bitmap.createScaledBitmap(bitmap, 150, 150, false);
        paint=new Paint();
        paint.setColor(Color.BLUE);

        control[0] = new RectF(150, 660, 150+controlWidth, 660+controlHeight);  // up
        control[1] = new RectF(150, 860, 150+controlWidth, 860+controlHeight);  // down
        control[2] = new RectF(45, 760, 45+controlWidth, 760+controlHeight);  // left
        control[3] = new RectF(250, 760, 250+controlWidth, 760+controlHeight);  // right
        control[4] = new RectF(1550, 760, 1550+controlWidth, 760+controlHeight);  // fire1
    }

    /*조이스틱 그리기*/
    public void paintJoyStick(Canvas canvas){
        // Up key
        for(int i=0 ; i<control.length ; i++){
            canvas.drawRect(control[i], paint);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(ship_bitmap, posX, posY, null);
        paintJoyStick(canvas);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
