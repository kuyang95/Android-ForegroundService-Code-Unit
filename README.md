# Android-ForegroundService-Code-Unit
배껴쓰는 코드조각
24/01/16 TargetSDK 33 기준

1. Manifest 에 권한 추가
```
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
<uses-permission
        android:name="android.permission.POST_NOTIFICATIONS"
        android:minSdkVersion="33" />
```
2. Manifest 에 서비스 추가
```
 <service
            android:name=".MyService"
            android:enabled="true"
        android:foregroundServiceType="connectedDevice" // 의도에 맞게 바꿔야함
>
        </service>
```



3. Activity 에서 startForegroundService 호출

4. MyService, ForegroundNotification 코드 그대로 쓰면됨

권한받는 코드는 없어서 설정가서 셀프로 하면됨

