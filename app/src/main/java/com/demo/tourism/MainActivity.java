package com.demo.tourism;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalAdapter horizontalAdapter;
    VerticalAdapter verticalAdapter;
    private List<ImageBean> list_hor;
    private List<ImageBean> list_ver;
    RecyclerView recycler_view_hor, recycler_view_vertical;
    FrameLayout fl_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView1();
        initRecyclerView2();
    }

    private void initData(){

        list_hor = new ArrayList<>();
        list_ver = new ArrayList<>();


        list_hor.add(new ImageBean(R.mipmap.phuketisland, "Phuket Island", "Phuket Island belongs to the jurisdiction of Thailand's Phuket Island, with an area of 543 square kilometers. It is the largest island in Thailand and the smallest island in Thailand. In 2014, the islanders numbered more than 600,000.\n" +
                "\n" +
                "Known as the jewel of the Andaman Sea, Kishima boasts charming tropical scenery and rich tourism resources. It is rich in natural resources and has the reputation of \"Treasure Island\". The main mineral is tin, which is also rich in rubber, seafood and various fruits. The island's industry and commerce, tourism more developed. The capital town of Phuket, located in the southeast of the island, is a large port and commercial center."));
        list_hor.add(new ImageBean(R.mipmap.provence, "Provence", "Provence is a \"city of knights\", is also the birthplace of the medieval love poem of knights, famous towns such as Marseilles and Aix. Provence is the world famous home of lavender and produces fine wines. Provence within the territory of Aix, Marseilles and other famous cities, as well as Arles, Gode, Avignon (and translated Avignon), Nimes and other towns.\n" +
                "\n" +
                "The region's bountiful, sunny and beautiful landscape has attracted countless visitors since ancient Greek and Roman times and is still a popular tourist destination today."));
        list_hor.add(new ImageBean(R.mipmap.angkorwat, "Angkor Wat", "Angkor Wat, also known as Angkor Wat, is located in Cambodia. Known as the national treasure of Cambodia, it is one of the largest temples in the world and is also built in the Khmer style. The original name of Angkor Wat is Vrah Vishnulok, which means \"the temple of Vishnu\" and is called \"Sangxiang Buddha Shrine\" in ancient Chinese Buddhist books. In the 12th century, the king of Angkor, Suryavarman II, wanted to build a grand cave temple on the flat ground to serve as the capital and temple of the Angkor empire. So it took the country about 35 years to build it. It is one of the most well-preserved buildings in Angkor, famous for its architectural grandeur and detailed relief."));
        list_hor.add(new ImageBean(R.mipmap.southisland, "South Island", "One of the two main islands constituting New Zealand in the southern part of the country separated from the North Island by the Cook Strait; Fovo Strait and Stewart Island across the south, west from Australia 1600 km, east Tonga, Fiji. The whole territory of New Zealand South Island is mountainous, mountainous area accounts for 50% of the national area. Whether luxuriant rain forests, clear lakes, or green grass and hillsides, water clear sand beaches, all show the freshness and beauty of New Zealand. Christchurch is the largest city in the South Island. Its historic stone buildings reflect the elegant English style, and its flowers, trees and parks have earned it the title of \"Garden City\"."));



        list_ver.add(new ImageBean(R.mipmap.symbian, "Saipan", "Saipan is the main island of the Mariana Islands (Commonwealth). Saipan and its neighboring islands are located near Asia on the Pacific Rim.  The Northern Mariana Islands have a pleasant climate, full of sunshine, fresh air, clear water and sand all year round.  The annual average temperature is about 27℃, it is a paradise for tourism and vacation."));
        list_ver.add(new ImageBean(R.mipmap.maldives, "Maldives", "Maldives is located near the equator, with obvious tropical climate characteristics, no four seasons.  The Maldives is rich in Marine resources, with a variety of tropical fish and sea products such as turtles, hawksbill turtles and corals and shells.  The Republic of Maldives (formerly known as The Maldives Islands) is an archipelago nation in The Indian Ocean."));
        list_ver.add(new ImageBean(R.mipmap.mountfuji, "Mount Fuji", "ふじさん Mount Fuji (Japanese: ふじさん) (English: Mount Fuji) is an active volcano that straddles the areas of Shizuoka (Fujiomiya City, Mordano City, Fuji City, Midanba City, Shuntoshimachi) and Yamanashi Prefecture (Fujiyoshida City, Narozawa Village, Minamitoru Prefecture) in Japan.  With a height of 3,776.24 meters, Mount Fuji is the highest mountain in Japan. It is widely known worldwide as a symbol of Japan."));
        list_ver.add(new ImageBean(R.mipmap.venice, "Venice", "Located in Italy's most famous city, Venice, it is one of the most romantic destinations in the world.  St. Mark's Square is in the heart of the city, surrounded by the famous cathedral.  Venice is a beautiful floating city.  It was built in the least likely place to build a city.  \n" +
                " \n" +
                "On the water, Venice is always inseparable from the \"water\", the channel, the flowing waves, she is like a floating in the blue waves.  Dreams of romance, poetry and painting have been lingering.  The city once had the strongest human resources and power in Europe."));
        list_ver.add(new ImageBean(R.mipmap.dubai, "Dubai", "Dubai is a modern international metropolis, the most populous city in the United Arab Emirates, the richest city in the Middle East and the economic and financial center of the Middle East. It is known as the \"Trade Capital of East and North Africa\" in the Middle East.  \n" +
                " \n" +
                "Dubai is one of the world's international financial centers and has become a bridge between Eastern capital markets.  It has also become an important logistics.  , trade, transportation, tourism and shopping center.  \n" +
                " \n" +
                "Facilities such as the world's first seven-star hotel (Burj Khalifa), the world's tallest skyscraper (Burj Khalifa), the world's largest shopping mall, and the world's largest indoor ski resort are all in Dubai, and the 2020 World Expo will also be held there."));

    }

    private void initRecyclerView1() {

        fl_home = findViewById(R.id.fl_home);

        recycler_view_hor = findViewById(R.id.recycler_view_hor);
        LinearLayoutManager manager_hor = new LinearLayoutManager(this);
        manager_hor.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view_hor.setLayoutManager(manager_hor);


        horizontalAdapter = new HorizontalAdapter(this, list_hor);
        recycler_view_hor.setAdapter(horizontalAdapter);
        horizontalAdapter.setItemOnclick(new ItemOnclick() {
            @Override
            public void onItem(ImageBean item) {
                showDetail(item);
            }
        });

        horizontalAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView2() {

        recycler_view_vertical = findViewById(R.id.recycler_view_vertical);
        LinearLayoutManager manager_hor = new LinearLayoutManager(this);
        manager_hor.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view_vertical.setLayoutManager(manager_hor);

        verticalAdapter = new VerticalAdapter(this, list_ver);
        recycler_view_vertical.setAdapter(verticalAdapter);
        verticalAdapter.setItemOnclick(new ItemOnclick() {
            @Override
            public void onItem(ImageBean item) {
                showDetail(item);
            }
        });

        verticalAdapter.notifyDataSetChanged();
    }

    public void back(){

        fl_home.removeAllViews();

        recycler_view_hor.setVisibility(View.VISIBLE);
        recycler_view_vertical.setVisibility(View.VISIBLE);

    }

    private void showDetail(ImageBean imageBean) {


        recycler_view_hor.setVisibility(View.GONE);
        recycler_view_vertical.setVisibility(View.GONE);


        Fragment f1 = DetailFragment.newInstance(imageBean);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_home, f1);
        ft.commit();
    }


    class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyHolder> {

        private Activity mContext;
        private List<ImageBean> mList;

        public void setItemOnclick(ItemOnclick itemOnclick) {
            this.itemOnclick = itemOnclick;
        }

        private ItemOnclick itemOnclick;

        VerticalAdapter(Activity context, List<ImageBean> list) {
            mContext = context;
            mList = list;
        }

        @Override
        public VerticalAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_tourism_vertical, parent, false);
            VerticalAdapter.MyHolder holder = new VerticalAdapter.MyHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(VerticalAdapter.MyHolder holder, int position) {

            holder.image.setImageResource(mList.get(position).getImage());
            holder.title.setText(mList.get(position).getTitle());
            holder.desc.setText(mList.get(position).getDesc());

            holder.itemView.setOnClickListener(v -> itemOnclick.onItem(mList.get(position)));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView title;
            TextView desc;

            public MyHolder(View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
                title = itemView.findViewById(R.id.title);
                desc = itemView.findViewById(R.id.desc);
            }
        }

    }

    class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyHolder> {

        private Activity mContext;
        private List<ImageBean> mList;

        public void setItemOnclick(ItemOnclick itemOnclick) {
            this.itemOnclick = itemOnclick;
        }

        private ItemOnclick itemOnclick;

        HorizontalAdapter(Activity context, List<ImageBean> list) {
            mContext = context;
            mList = list;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_tourism_hori, parent, false);
            MyHolder holder = new MyHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.image.setImageResource(mList.get(position).getImage());

            holder.image.getLayoutParams().width = (getScreenWidth() - dp2px(10) * 4) / 3;

            holder.itemView.setOnClickListener(v -> itemOnclick.onItem(mList.get(position)));
        }

        public int getScreenWidth() {

            return mContext.getResources().getDisplayMetrics().widthPixels;

        }

        public int dp2px(float dp) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dp, mContext.getResources().getDisplayMetrics());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            ImageView image;

            public MyHolder(View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
            }
        }

    }

    class ImageBean implements Serializable {

        private static final long serialVersionUID = -5809782578272943999L;

        private int image;
        private String title;
        private String desc;

        public ImageBean(int image, String title, String desc) {
            this.image = image;
            this.title = title;
            this.desc = desc;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    interface ItemOnclick {
        void onItem(ImageBean item);
    }

    public static class DetailFragment extends Fragment {

        private static String KEY_BEAN = "KEY_BEAN";
        private ImageBean mImageBean;

        public static Fragment newInstance(ImageBean imageBean) {

            DetailFragment fragment = new DetailFragment();

            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_BEAN, imageBean);
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments()!=null){
                mImageBean = (ImageBean) getArguments().getSerializable(KEY_BEAN);
            }
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            ImageView back = rootView.findViewById(R.id.back);
            ImageView imageView = rootView.findViewById(R.id.image);
            TextView title = rootView.findViewById(R.id.title);
            TextView desc = rootView.findViewById(R.id.desc);

            imageView.setImageResource(mImageBean.getImage());
            title.setText(mImageBean.getTitle());
            desc.setText(mImageBean.getDesc());


            back.setOnClickListener(v -> ((MainActivity)getActivity()).back());

            return rootView;

        }

        @Override
        public void onResume() {
            super.onResume();

        }
    }

}



