package com.yuntongxun.ecdemo.ui.chatting.model;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import com.yuntongxun.ecdemo.R;
import com.yuntongxun.ecdemo.ui.chatting.ChattingActivity;
import com.yuntongxun.ecdemo.ui.chatting.holder.BaseHolder;
import com.yuntongxun.ecdemo.ui.chatting.holder.DescriptionViewHolder;
import com.yuntongxun.ecdemo.ui.chatting.holder.LocationViewHolder;
import com.yuntongxun.ecdemo.ui.chatting.view.ChattingItemContainer;
import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.im.ECLocationMessageBody;
import com.yuntongxun.ecsdk.im.ECTextMessageBody;

public class LocationRxRow extends BaseChattingRow {

	public LocationRxRow(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View buildChatView(LayoutInflater inflater, View convertView) {
			
		 if (convertView == null ) {
	            convertView = new ChattingItemContainer(inflater, R.layout.chatting_item_location_from);
	            LocationViewHolder holder = new LocationViewHolder(mRowType);
	            convertView.setTag(holder.initBaseHolder(convertView, true));
	        } 
			return convertView;
	
	}

	@Override
	public int getChatViewType() {
		// TODO Auto-generated method stub
		return ChattingRowType.LOCATION_ROW_RECEIVED.ordinal();
	}

	@Override
	public boolean onCreateRowContextMenu(ContextMenu contextMenu,
			View targetView, ECMessage detail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void buildChattingData(Context context, BaseHolder baseHolder,
			ECMessage detail, int position) {
		LocationViewHolder holder = (LocationViewHolder) baseHolder;
		ECMessage message = detail;
		if(message != null) {
			
			ViewHolderTag holderTag = ViewHolderTag.createTag(detail,
					ViewHolderTag.TagType.TAG_IM_LOCATION, position);
			
			ECLocationMessageBody textBody = (ECLocationMessageBody) message.getBody();
			holder.descTextView.setText(textBody.getTitle());
			OnClickListener onClickListener = ((ChattingActivity) context).mChattingFragment.getChattingAdapter().getOnClickListener();
			holder.relativeLayout.setTag(holderTag);
			holder.relativeLayout.setOnClickListener(onClickListener);
		}
		
		

	}

}
