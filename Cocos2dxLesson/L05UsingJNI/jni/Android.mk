LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := L05UsingJNI
LOCAL_SRC_FILES := L05UsingJNI.cpp

include $(BUILD_SHARED_LIBRARY)
