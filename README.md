NoRepeatClickListener
============
防止一段時間內重複觸發點擊事件。
預設為一秒。
```Kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.setOnClickListener(NoRepeatClickListener{Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()})
//        or
//        tv_hello.setNoRepeatOnClickListener {Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()}
    }
    fun View.setNoRepeatOnClickListener(Click: (View) -> Unit) {
        val noRepeatClickListener = NoRepeatClickListener {
            Click(it)
        }
        setOnClickListener(noRepeatClickListener)
    }
}

```

Download
--------

```groovy
dependencies {
    implementation 'com.deyu:norepeatclicklistener:1.0.0'
}
```
