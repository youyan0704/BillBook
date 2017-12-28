package com.you.yan.billbook;

/**
 * Created by android on 11/20/17.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.you.yan.billbook.SlideTouchView.SlideBaseAdapter;

import java.util.List;

public abstract class CommonAdapter<T> extends SlideBaseAdapter {

    /**
     * 数据源
     */
    protected List<T> datas = null;

    /**
     * 上下文对象
     */
    protected Context context = null;

    /**
     * item布局文件的资源ID
     */
    protected int itemLayoutResId = 0;

    public CommonAdapter(Context context, List<T> datas, int itemLayoutResId) {
        this.context = context;
        this.datas = datas;
        this.itemLayoutResId = itemLayoutResId;
    }

    @Override
    public int getCount() {
        if (datas != null){
            return datas.size();
        }
        return 0;
    }

    /**
     * 提供给Activity刷新数据
     * @param list
     */
    public void updateList(List<T> list){
        this.datas = list;
        notifyDataSetChanged();
    }


    /**
     * 注意，返回值也要为泛型
     */
    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(context, itemLayoutResId, position, convertView, parent);

        convert(viewHolder, getItem(position));
        bindSlideStatus(viewHolder);
        bindSlidePosition(viewHolder,position);
        return viewHolder.getConvertView();
    }

    /**
     * 开发者实现该方法，进行业务处理
     */
    public abstract void convert(CommonViewHolder viewHolder, T item);
    //下面两个接口是绑定左滑
    public abstract void bindSlideStatus(CommonViewHolder viewHolder);
    public abstract void bindSlidePosition(CommonViewHolder viewHolder, int pos);
}
