package zzr.com.mylayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CollapseActivity extends AppCompatActivity {
    private ArrayList<String> datas=new ArrayList<>();
    private Toolbar toolbar;
    private RecyclerView rv_list;
    private SecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            datas.add("续一秒"+i);
        }
    }

    private void initView() {
        toolbar= (Toolbar) this.findViewById(R.id.toolbar2);
        toolbar.setTitle("折叠布菊");
        rv_list= (RecyclerView) this.findViewById(R.id.rv_list);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rv_list.setLayoutManager(manager);
        adapter=new SecAdapter();
        rv_list.setAdapter(adapter);



    }


    class SecAdapter extends RecyclerView.Adapter<SecAdapter.MyHolder>{


        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = View.inflate(parent.getContext(), android.R.layout.simple_expandable_list_item_1, null);
            MyHolder myHolder=new MyHolder(root);
            return myHolder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public MyHolder(View itemView) {
                super(itemView);
                tv= (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
