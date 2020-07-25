package com.example.shamithhshetty.userprofile_android;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shamithhshetty.userprofile_android.Model.CardItem;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    Context context;

    public CardPagerAdapter(Context context) {
        this.context=context;
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(mData.get(position), view,position);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, final View view, final int position) {
        //tittle
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        final TextView tname1 = (TextView) view.findViewById(R.id.tname1);
        final TextView tname2 = (TextView) view.findViewById(R.id.tname2);
        final TextView txtname1 = (TextView) view.findViewById(R.id.txtname1);
        final TextView txtname2= (TextView) view.findViewById(R.id.txtname2);
        //image icons for name1,name2
        ImageView img1=(ImageView) view.findViewById(R.id.imgname1);
        ImageView img2=(ImageView) view.findViewById(R.id.imgname2);
        //image icons for edit
        ImageView edit1=(ImageView) view.findViewById(R.id.edit1);
        ImageView edit2=(ImageView) view.findViewById(R.id.edit2);

        img1.setImageResource(item.getId1());
        img2.setImageResource(item.getId2());

        titleTextView.setText(item.getTittle());
        tname1.setText(item.getTname1());
        tname2.setText(item.getTname2());
        txtname1.setText(item.getName1());
        txtname2.setText(item.getName2());

        //redirect to other page code Important!!!!!!!!!!
        //case 1:context.startActivities(new Intent[]{new  Intent(context, HomeActivity.class)});break;

        //alert diaglogbox
        final LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final AlertDialog.Builder alert=new AlertDialog.Builder(context);
        final View mview=inflater.inflate(R.layout.custom_promptbox,null);
        final Button btnupadte=(Button) mview.findViewById(R.id.btnupdate);
        final ImageView btncancel=(ImageView)mview.findViewById(R.id.btncancel);
        final TextInputEditText promptimp=(TextInputEditText) mview.findViewById(R.id.txtinput);
        final TextInputLayout txtinpulayout=(TextInputLayout) mview.findViewById(R.id.txtinputlayout);
        final AlertDialog alertDialogparent=null;
        //edit click one
        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add set alertbox
                txtinpulayout.setHint(tname1.getText().toString().trim());
                promptimp.setText(txtname1.getText().toString().trim());
                if(mview.getParent() != null) {
                    ((ViewGroup) mview.getParent()).removeView(mview); // <- fix
                }
                alert.setView(mview);
                AlertDialog samplebox=alertDialogparent;
                samplebox=alert.create();
                final AlertDialog alertDialog=samplebox;
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnupadte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtname1.setText(promptimp.getText().toString());
                        alertDialog.dismiss();
                        Toast.makeText(context, "Updated Sucessfully......", Toast.LENGTH_SHORT).show();
                    }
                });
                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
        //edit click one
        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add set alertbox
                txtinpulayout.setHint(tname2.getText().toString().trim());
                promptimp.setText(txtname2.getText().toString().trim());
                if(mview.getParent() != null) {
                    ((ViewGroup) mview.getParent()).removeView(mview); // <- fix
                }
                alert.setView(mview);
                AlertDialog samplebox=alertDialogparent;
                samplebox=alert.create();
                final AlertDialog alertDialog=samplebox;
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnupadte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtname2.setText(promptimp.getText().toString());
                        alertDialog.dismiss();
                        Toast.makeText(context, "Updated Sucessfully......", Toast.LENGTH_SHORT).show();
                    }
                });
                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
    }




}
