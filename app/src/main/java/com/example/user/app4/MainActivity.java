package com.example.user.app4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnBtnPress {

    private MenuFragment menu;
    int rCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rCnt = 1;

        menu = new MenuFragment();

        setCurrentFragment(R.id.container, menu, false);

        //Button button = (Button) findViewById(R.id.btnPage4);
        //button.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v) {
        //        getWeather();
        //    }
       // });
    }

    @Override
    public void btnPressed(int btn) {
        rCnt = 1;
        switch (btn) {
            case MenuFragment.BTN_4PDA:
                setCurrentFragment(R.id.container, new WebFragment(),true);
                break;
            case MenuFragment.BTN_IMAGE:
                setCurrentFragment(R.id.container, new ImageFragment(),true);
                break;
            case MenuFragment.BTN_PAGE_1:
                setCurrentFragment(R.id.container, OtherFragment.getInstance("СЕРГЕЙ ЕСЕНИН",
                        "Заметался пожар голубой,\n" +
                        "Позабылись родимые дали.\n" +
                        "В первый раз я запел про любовь,\n" +
                        "В первый раз отрекаюсь скандалить.\n" +
                        "\n" +
                        "Был я весь - как запущенный сад,\n" +
                        "Был на женщин и зелие падкий.\n" +
                        "Разонравилось пить и плясать\n" +
                        "И терять свою жизнь без оглядки.\n" +
                        "       \n" +
                        "Мне бы только смотреть на тебя,\n" +
                        "Видеть глаз злато-карий омут,\n" +
                        "И чтоб, прошлое не любя,\n" +
                        "Ты уйти не смогла к другому.\n" +
                        "\n" +
                        "Поступь нежная, легкий стан,\n" +
                        "Если б знала ты сердцем упорным,\n" +
                        "Как умеет любить хулиган,\n" +
                        "Как умеет он быть покорным.\n" +
                        "       \n" +
                        "Я б навеки забыл кабаки\n" +
                        "И стихи бы писать забросил.\n" +
                        "Только б тонко касаться руки\n" +
                        "И волос твоих цветом в осень.\n" +
                        "       \n" +
                        "Я б навеки пошел за тобой\n" +
                        "Хоть в свои, хоть в чужие дали...\n" +
                        "В первый раз я запел про любовь,\n" +
                        "В первый раз отрекаюсь скандалить."),true);
                break;
            case MenuFragment.BTN_PAGE_2:
                setCurrentFragment(R.id.container, new WebFragmentArticle(),true);
                break;
            case MenuFragment.BTN_PAGE_3:
                setCurrentFragment(R.id.container, OtherFragment.getInstance("ВЛАДИМИР ВЫСОЦКИЙ",
                        "Смеюсь навзрыд среди кривых зеркал,\n" +
                        "Меня, должно быть, ловко разыграли:\n" +
                        "Крючки носов и до ушей оскал -\n" +
                        "Как на венецианском карнавале\n" +
                        "\n" +
                        "Что делать мне? Бежать, да поскорей?\n" +
                        "А может, вместе с ними веселиться?\n" +
                        "Надеюсь я - под маскою зверей\n" +
                        "У многих человеческие лица.\n" +
                        "\n" +
                        "Все в масках, париках - все, как один.\n" +
                        "Кто сказочен, а кто - литературен.\n" +
                        "Сосед мой справа - грустный арлекин,\n" +
                        "Другой палач, а каждый третий - дурень.\n" +
                        "\n" +
                        "Я в хоровод вступаю хохоча,\n" +
                        "Но все-таки мне неспокойно с ними, -\n" +
                        "А вдруг кому-то маска палача\n" +
                        "Понравится, и он ее не снимет?\n" +
                        "\n" +
                        "Вдруг арлекин навеки загрустит,\n" +
                        "Любуясь сам своим лицом печальным?\n" +
                        "Что, если дурень свой дурацкий вид\n" +
                        "Так и забудет на лице нормальном?\n" +
                        "\n" +
                        "Вокруг меня смыкается кольцо,\n" +
                        "Меня хватают, вовлекают в пляску.\n" +
                        "Так-так, мое обычное лицо\n" +
                        "Все остальные приняли за маску.\n" +
                        "\n" +
                        "Петарды, конфетти! Но все не так...\n" +
                        "И маски на меня глядят с укором.\n" +
                        "Они кричат, что я опять не в такт,\n" +
                        "Что наступаю на ноги партнерам.\n" +
                        "\n" +
                        "Смеются злые маски надо мной,\n" +
                        "Веселые - те начинают злиться,\n" +
                        "За маской пряча, словно за стеной,\n" +
                        "Свои людские подлинные лица.\n" +
                        "\n" +
                        "За музами гоняюсь по пятам,\n" +
                        "Но ни одну не попрошу открыться:\n" +
                        "Что, если маски сброшены, а там\n" +
                        "Все те же полумаски-полулица?\n" +
                        "\n" +
                        "Я в тайну масок все-таки проник.\n" +
                        "Уверен я, что мой анализ точен:\n" +
                        "И маска равнодушья у иных -\n" +
                        "Защита от плевков и от пощечин.\n" +
                        "\n" +
                        "Но если был без маски подлецом,\n" +
                        "Носи ее. А вы? У вас все ясно.\n" +
                        "Зачем скрываться под чужим лицом,\n" +
                        "Когда свое, воистину, прекрасно?\n" +
                        "\n" +
                        "Как доброго лица не прозевать,\n" +
                        "Как честных угадать наверняка мне?\n" +
                        "Они решили маски надевать,\n" +
                        "Чтоб не разбить свое лицо о камни."),true);
                break;
            case MenuFragment.BTN_JSON:
                setCurrentFragment(R.id.container, new WeatherFragment(), true);
                break;
        }
        }

    @Override
    protected void onPause() {
        menu.removeBtnPressListener();
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        menu.setBtnPressListener(this);
    }

    private void setCurrentFragment(int container, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        final int count = getFragmentManager().getBackStackEntryCount();
            if (count > 0) {
                getFragmentManager().popBackStack();
            } else {
                if (rCnt == 1) {
                    Context context = getApplicationContext();
                    CharSequence text = "Для закрытия нажмите еще раз <Назад>";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    --rCnt;
                } else {
                    super.onBackPressed();
                }
            }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getWeather() {

        new AsyncTask<Void, Void, API.ApiResponse>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected API.ApiResponse doInBackground(Void... x) {
                ArrayList<String> params = new ArrayList<String>();
                params.add("id");
                params.add("498677");
                params.add("APPID");
                params.add("0408201c1a78c86fd9433b7efbc51b4f");
                params.add("lang");
                params.add("ru");
                params.add("units");
                params.add("metric");

                return API.execute( API.ApiMethod.GET_WEATHER.format(),
                        API.HttpMethod.GET,
                        params.toArray(new String[params.size()])
                );
            }

            @Override
            protected void onPostExecute(API.ApiResponse apiResponse) {
                super.onPostExecute(apiResponse);

                try {
                    if (apiResponse.isSuccess()) {
                        android.util.Log.d("Weather",apiResponse.getJson().toString());

                    }

                } catch (Exception e) {
                    android.util.Log.e("Weather", "ALERT! ALERT! Exception!", e);
                } finally {

                }

                Intent intent = new Intent(MainActivity.this, Weather_Hilfe.class);
                intent.putExtra("info", apiResponse.getJson().toString());
                startActivity(intent);
            }
        }.execute();
    }

}

/*import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnBtnPress {

    private MenuFragment menu;
    //public int menuContainerID;
    int rCnt;

    @Override
/*    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rCnt = 1;
        menu = new MenuFragment();

        chConfig(getResources().getConfiguration());
    }*/

/*    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCnt = 1;
        menu = new MenuFragment();

        setCurrentFragment(menu, false);
    }

    @Override
    public void btnPressed(int btn) {
        rCnt = 1;

        switch (btn) {
            case MenuFragment.BTN_4PDA:
                setCurrentFragment(R.id.container, new WebFragment(),true);
                break;
            case MenuFragment.BTN_IMAGE:
                setCurrentFragment(R.id.container, new ImageFragment(),true);
                break;
            case MenuFragment.BTN_PAGE_1:
                setCurrentFragment(R.id.container, OtherFragment.getInstance("PAGE 1","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In posuere elementum justo. Donec eget dapibus nisi, ut auctor ex. Nullam sodales, ipsum quis efficitur sollicitudin, eros neque fringilla nunc, vitae scelerisque lectus lacus non dolor. Vivamus a libero a est gravida mollis. Pellentesque vitae egestas metus. Fusce vitae vestibulum felis. Quisque ac tincidunt eros. Nulla id vulputate odio. Ut interdum, massa ac ullamcorper rutrum, magna ipsum rhoncus quam, ac finibus justo nunc non quam. Proin suscipit venenatis lobortis. Phasellus varius ut elit sit amet aliquet. Donec vitae venenatis mi. Pellentesque elit diam, venenatis id leo et, rutrum euismod metus. Morbi suscipit, orci vestibulum ultricies cursus, libero nunc aliquet neque, vitae finibus mauris felis rhoncus est. Morbi id quam in magna cursus congue eget et ipsum."),true);
                break;
            case MenuFragment.BTN_PAGE_2:
                setCurrentFragment(R.id.container, OtherFragment.getInstance("PAGE 2","Nam fermentum, odio quis interdum semper, leo nibh vulputate neque, a commodo nunc purus quis risus. Integer sodales posuere neque et aliquam. Ut commodo, sem a tempor feugiat, quam augue dapibus metus, ut elementum nulla velit et lacus. Donec id enim dolor. Quisque ac quam libero. Cras consequat nisi ante, at pellentesque sapien fermentum ac. Donec hendrerit lectus ipsum, non sollicitudin risus facilisis quis. Proin mollis sapien metus, ut facilisis justo congue eu. Pellentesque luctus ante at faucibus sollicitudin. Cras eu malesuada nisi, vitae mattis nibh. Praesent semper risus ac luctus interdum. Mauris imperdiet dapibus nibh, id varius tortor pharetra at. Nullam sit amet imperdiet neque. Proin mattis ultricies molestie. Quisque in massa vitae augue tincidunt luctus. Suspendisse nec leo quis elit interdum convallis in ac ipsum."),true);
                break;
            case MenuFragment.BTN_PAGE_3:
                setCurrentFragment(R.id.container, OtherFragment.getInstance("PAGE 3","Aenean euismod sed felis non lobortis. Nunc condimentum ultrices tellus, ut pharetra felis tincidunt luctus. Cras eget orci ac nisi congue porta. Vivamus nec luctus erat, sed lacinia augue. Aenean luctus, magna vitae tincidunt accumsan, libero erat aliquet nunc, in cursus nisl libero vel mi. Sed scelerisque, velit eu elementum mattis, velit purus lacinia diam, et finibus augue eros sed turpis. Aenean et mauris nulla. Aenean at felis non nibh tempus vestibulum. Pellentesque sagittis vulputate dui ut malesuada. Nam porta libero enim, id vestibulum diam viverra sit amet. Duis vitae imperdiet nulla. Aenean dictum ante in eros cursus, id mattis libero feugiat. Donec eget enim ac libero commodo commodo id non eros. Fusce at tristique elit, vel laoreet est. Maecenas lacus magna, porta at gravida feugiat, finibus at magna. Donec convallis ligula non feugiat tempus."),true);
                break;
            //case MenuFragment.BTN_JSON:
            //    setCurrentFragment(R.id.container, new WeatherFragment(), true);
            //    break;
        }
    }
/*
    @Override
    protected void onPause() {
        menu.removeBtnPressListener();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        menu.setBtnPressListener(this);
    }

    private void setCurrentFragment(int containerID, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(containerID, fragment);
        if (addToBackStack) transaction.addToBackStack("general");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        final int count = getFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            getFragmentManager().popBackStack();
        } else {
            if (rCnt == 1) {
                Context context = getApplicationContext();
                CharSequence text = "Для закрытия нажмите еще раз <Назад>";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                --rCnt;
            } else {
                super.onBackPressed();
            }
        }
    }

/*    private void chConfig(Configuration newConfig) {
        // Checks the orientation of the screen
        getFragmentManager().popBackStack("general", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            menuContainerID = R.id.containerMenu;
            findViewById(R.id.containerMenu).setVisibility(View.VISIBLE);
            getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.container)).commit();
            setCurrentFragment(menuContainerID, menu, false);
//            ((FrameLayout)findViewById(R.id.container)).removeAllViews();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            menuContainerID = R.id.container;
            setCurrentFragment(menuContainerID, menu, false);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        chConfig(newConfig);
    }*/
