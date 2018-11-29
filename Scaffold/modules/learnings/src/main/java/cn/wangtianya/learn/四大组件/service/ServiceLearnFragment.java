package cn.wangtianya.learn.四大组件.service;

import com.qjuzi.architecure.base.context.ContextCache;
import com.wangtianya.learn.common.ItemFragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by wangtianya on 2018/3/14.
 */

public class ServiceLearnFragment extends ItemFragment {

    public void dododo() {
        Intent intent = new Intent(ContextCache.getContext(), LearnService.class);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ContextCache.getContext().startForegroundService(intent);
                dododo();
            }
        },6000);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        addClickItem("startService", v -> {
            dododo();
        });

        addClickItem("stopService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextCache.getContext(), LearnService.class);
                ContextCache.getContext().stopService(intent);
            }
        });


        addClickItem("bindService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextCache.getContext(), LearnService.class);
                getActivity().bindService(intent,connection, Context.BIND_AUTO_CREATE);
            }
        });

        addClickItem("unBindService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().unbindService(connection);
            }
        });


        addClickItem("-------------------------", null);


        addClickItem("startIntentService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextCache.getContext(), MyIntentService.class);
                intent.setAction("love");
                intent.putExtra("love", "mememe");
                ContextCache.getContext().startService(intent);
            }
        });

        addClickItem("bindService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextCache.getContext(), MyIntentService.class);
                getActivity().bindService(intent,connection, Context.BIND_AUTO_CREATE);
            }
        });

        addClickItem("stopIntentService", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextCache.getContext(), MyIntentService.class);
                ContextCache.getContext().stopService(intent);
            }
        });



        addClickItem("enqueueWorkJobIntentTestService", v ->{
            Intent intent = new Intent(ContextCache.getContext(), JobIntentTestService.class);
            JobIntentTestService.enqueueWork(ContextCache.getContext(), intent);
        });

        addClickItem("startJobIntentTestService", v ->{
//            Intent intent = new Intent(ContextCache.getContext(), JobIntentTestService.class);
            Intent intent = new Intent();
            intent.setClassName(ContextCache.getContext(), "cn.wangtianya.learn.四大组件.service.JobIntentTestService");
            ContextCache.getContext().startService(intent);
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("onServiceConnected", "onServiceConnected： " + name);
            ((MyIBinder)service).sayHello();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("onServiceConnected", "onServiceConnected");
        }
    };

}


