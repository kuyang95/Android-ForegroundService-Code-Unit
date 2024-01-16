# Android-ForegroundService-Code-Unit
배껴쓰는 코드조각
24/01/16 TargetSDK 33 기준

1. Manifest 에 권한 추가
'''Kotlin
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
<uses-permission
        android:name="android.permission.POST_NOTIFICATIONS"
        android:minSdkVersion="33" />
'''
3. Manifest 에 서비스 추가
 <service
            android:name=".MyService"
            android:enabled="true"
        </service>

4. Activity 에서 startForegroundService 호출

5. MyService, ForegroundNotification 코드 그대로 쓰면됨

6. 권한받는 코드는 없어서 설정가서 셀프로 하면됨

