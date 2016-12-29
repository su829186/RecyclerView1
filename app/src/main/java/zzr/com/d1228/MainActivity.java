package zzr.com.d1228;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_content;
    private ArrayList<String> data;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initData();
        initView();
        init();
    }

    private void init() {

    }

    private void initData() {
        data=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("续"+i+"秒");
        }
    }

    private void initView() {
        rv_content= (RecyclerView) this.findViewById(R.id.rv_content);
        //列表
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //网格
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);
        //瀑布
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);

        rv_content.setLayoutManager(staggeredGridLayoutManager);
        adapter=new MyAdapter();
        rv_content.setAdapter(adapter);



    }
    @Subscribe
    public void onClick(Integer position){
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }



    public void delete(int position){
        data.remove(position);
        adapter.notifyDataSetChanged();

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        //创建View结构
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = View.inflate(parent.getContext(), android.R.layout.simple_expandable_list_item_1, null);

            ViewHolder holder=new ViewHolder(root);
            return holder;
        }
        //填充数据
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public ViewHolder(View itemView) {
                super(itemView);
                tv= (TextView) itemView.findViewById(android.R.id.text1);
                tv.setClickable(true);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventBus.getDefault().post(getAdapterPosition());
                    }
                });

/*                //上下文菜单
                tv.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                    @Override
                    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                        MenuItem item = menu.add(0, 0, 0, "删除");
                        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                delete(getAdapterPosition());
                                return false;
                            }
                        });
                    }
                });*/


                tv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        View item = View.inflate(v.getContext(), R.layout.item, null);
                        PopupWindow window=new PopupWindow(item,400,50,true);
                        window.setBackgroundDrawable(new BitmapDrawable());
                        window.showAsDropDown(v,0,-100);

                        return false;
                    }
                });



            }
        }
    }




}
