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

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> data;
    private RecyclerView rv_content;
    private Toolbar toolbar;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        toolbar= (Toolbar) this.findViewById(R.id.toolbar);
        toolbar.setTitle("工具栏");
        rv_content= (RecyclerView) this.findViewById(R.id.rv_content);
        LinearLayoutManager manager=new LinearLayoutManager(this);

        rv_content.setLayoutManager(manager);
        adapter=new MyAdapter();
        rv_content.setAdapter(adapter);


    }

    private void initData() {
        data=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("bilibi"+i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = View.inflate(parent.getContext(), android.R.layout.simple_expandable_list_item_1, null);
            ViewHolder holder=new ViewHolder(root);

            return holder;
        }

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
            }
        }
    }
}
