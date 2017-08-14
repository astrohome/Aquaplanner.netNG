package com.galaxysoft.aquaplannernetng.model

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView

import com.galaxysoft.aquaplannernetng.R
import org.w3c.dom.Text

import java.util.ArrayList

class TaskAdapter(mContext: Context) : ArrayAdapter<Task> (mContext, R.layout.task_row_item) {

    // View lookup cache
    private class ViewHolder {
        internal var txtOrder: TextView? = null
        internal var txtType: TextView? = null
        internal var txtOutputChannel: TextView? = null
        internal var txtStartTime: TextView? = null
        internal var txtEndTime: TextView? = null
        internal var txtStartPwm: TextView? = null
        internal var txtEndPwm: TextView? = null
    }
    /*
    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object = getItem(position);
        Task dataModel= (Task) object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }*/

    private var lastPosition = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // Get the data item for this position
        val dataModel = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder // view lookup cache stored in tag
        if (convertView == null) {

            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.task_row_item, parent, false)
            viewHolder.txtOrder = convertView!!.findViewById<TextView>(R.id.tskOrder)
            viewHolder.txtType = convertView.findViewById<TextView>(R.id.tskType)
            viewHolder.txtOutputChannel = convertView.findViewById<TextView>(R.id.tskOutputChannel)
            viewHolder.txtStartTime = convertView.findViewById<TextView>(R.id.tskStartTime)
            viewHolder.txtEndTime = convertView.findViewById<TextView>(R.id.tskEndTime)
            viewHolder.txtStartPwm = convertView.findViewById<TextView>(R.id.tskPwmOn)
            viewHolder.txtEndPwm = convertView.findViewById<TextView>(R.id.tskPwmOff)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        /*Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);*/
        lastPosition = position

        viewHolder.txtOrder!!.text = dataModel!!.order.toString()
        viewHolder.txtType!!.text = dataModel.mode.toString()
        viewHolder.txtOutputChannel!!.text = dataModel.outputChannel.toString()
        viewHolder.txtStartTime!!.text = dataModel.startTime!!.toString("HH:mm")
        viewHolder.txtEndTime!!.text = dataModel.endTime!!.toString("HH:mm")
        viewHolder.txtStartPwm!!.text = dataModel.startPwm.toString()
        viewHolder.txtEndPwm!!.text = dataModel.endPwm.toString()

        // Return the completed view to render on screen
        return convertView
    }
}
