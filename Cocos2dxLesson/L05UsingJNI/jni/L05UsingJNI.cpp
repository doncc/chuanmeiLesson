#include <jni.h>
#include <com_chuanmei_l05usingjni_People.h>

/*
 * Class:     com_chuanmei_l05usingjni_People
 * Method:    getName
 * Signature: ()Ljava/lang/String;
 */
jstring Java_com_chuanmei_l05usingjni_People_getName(JNIEnv *env, jobject thiz) {
	return env->NewStringUTF("abc");
}

/*
 * Class:     com_chuanmei_l05usingjni_People
 * Method:    getAge
 * Signature: ()I
 */
jint Java_com_chuanmei_l05usingjni_People_getAge(JNIEnv *env, jobject thiz) {
	return 10;
}

