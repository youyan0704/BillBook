package com.you.yan.billbook;

/**
 * Created by android on 11/20/17.
 */

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.you.yan.billbook.SlideTouchView.SlideTouchView;

/**
 * 通用的ViewHolder
 *
 * @author owen
 */
public class CommonViewHolder {

    /**
     * 存储item中所用控件引用的容器
     *
     * Key - 资源ID
     * Value - 控件的引用
     */
    private SparseArray<View> views = null;

    private View convertView = null;

    private int position = 0;

    /**
     * 私有化的构造函数，有类内部来管理该实例
     *
     * @param context 上下文对象
     * @param itemLayoutResId item的布局文件的资源ID
     * @param position BaseAdapter.getView()的传入参数
     * @param parent BaseAdapter.getView()的传入参数
     */
    private CommonViewHolder(Context context, int itemLayoutResId, int position, ViewGroup parent) {
        this.views = new SparseArray<View>();
        this.position = position;
        this.convertView = LayoutInflater.from(context).inflate(itemLayoutResId, parent, false);

        convertView.setTag(this);
    }

    /**
     * 得到一个ViewHolder对象
     *
     * @param context 上下文对象
     * @param itemLayoutResId item的布局文件的资源ID
     * @param position BaseAdapter.getView()的传入参数
     * @param convertView BaseAdapter.getView()的传入参数
     * @param parent BaseAdapter.getView()的传入参数
     * @return 一个ViewHolder对象
     */
    public static CommonViewHolder getViewHolder(Context context, int itemLayoutResId, int position,
                                                 View convertView, ViewGroup parent) {
        if (convertView == null) {
            return new CommonViewHolder(context, itemLayoutResId, position, parent);
        } else {
            CommonViewHolder viewHolder = (CommonViewHolder) convertView.getTag();
            viewHolder.position = position; // 这里要更新一下position，因为position一直发生变化
            return viewHolder;
        }
    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * 【核心部分】
     * 根据控件的资源ID，获取控件
     *
     * @param viewResId 控件的资源ID
     * @return 控件的引用
     */
    public <T extends View> T getView(int viewResId) {
        View view = views.get(viewResId);

        if (view == null) {
            view = convertView.findViewById(viewResId);
            views.put(viewResId, view);
        }

        return (T) view;
    }

    public CommonViewHolder setText(int viewResId, String text) {
        TextView tv = getView(viewResId);
        tv.setText(text);

        return this;
    }

    public CommonViewHolder setTextColor(int viewResId, int ResId) {
        TextView tv = getView(viewResId);
        tv.setTextColor(ResId);

        return this;
    }

    public CommonViewHolder setImageResource(int viewResId,int ResId){
        ImageView iv = getView(viewResId);
        iv.setImageResource(ResId);

        return this;
    }

    public SlideTouchView setSwipeLayouyt(int viewResId){
        SlideTouchView slideTouchView = getView(viewResId);

        return slideTouchView;
    }

    public CommonViewHolder setChecked(int viewResId, boolean isChecked) {
        CheckBox checkBox = getView(viewResId);
        checkBox.setChecked(isChecked ? true : false);

        return this;
    }
}
