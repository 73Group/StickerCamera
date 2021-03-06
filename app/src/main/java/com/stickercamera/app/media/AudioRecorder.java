package com.stickercamera.app.media;

import android.media.MediaRecorder;

import com.stickercamera.AppConstants;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class AudioRecorder {

	private MediaRecorder mMediaRecorder;  
	private String mDir;             
	private String mCurrentFilePath;
	private String mCurrentFileName;

	private static AudioRecorder mInstance;

	private boolean isPrepared;
	private int duration = 0;
    private long startTime = 0;

	private AudioRecorder(String dir) {
		mDir = dir;
	}

	public interface AudioStateListener {
		void wellPrepared();    
	}

	public AudioStateListener mListener;

	public void setOnAudioStateListener(AudioStateListener audioStateListener) {
		mListener = audioStateListener;
	}
	
	public static AudioRecorder getInstance() {
		if (mInstance == null) {
			synchronized (AudioRecorder.class) {
				if (mInstance == null) {
					mInstance = new AudioRecorder(AppConstants.APP_ADUIO);
				}
			}
		}

		return mInstance;
	}



	public void prepareAudio() {

		try {
			isPrepared = false;

			File dir = new File(mDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String fileName = generateFileName();
			File file = new File(dir, fileName);  

			mMediaRecorder = new MediaRecorder();
			mCurrentFilePath = file.getAbsolutePath();
			mCurrentFileName = fileName;
			
		
			mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);   
			mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB); 
			mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			mMediaRecorder.setOutputFile(file.getAbsolutePath());
			mMediaRecorder.prepare();

			mMediaRecorder.start();
			startTime = System.currentTimeMillis();
            duration = 0;
			isPrepared = true; 

			if (mListener != null) {
				mListener.wellPrepared();
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

	}

	private String generateFileName() {
		return UUID.randomUUID().toString() + ".amr"; 
	}

	public int getVoiceLevel(int maxLevel) {
		if (isPrepared) {
			try {
				return maxLevel * mMediaRecorder.getMaxAmplitude() / 32768 + 1;
			} catch (Exception e) {
			}
		}
		return 1;
	}

	public void release() {
		try {
			mMediaRecorder.stop();
			mMediaRecorder.release();
            duration = (int) ((System.currentTimeMillis() - startTime) / 1000 + 0.5);
        } catch (IllegalStateException e) {
			e.printStackTrace();
		}finally {
			if(mMediaRecorder != null){
				mMediaRecorder = null;
			}
		}
	
	}

	public void cancel() {

		release();

		if (mCurrentFilePath != null) {
			File file = new File(mCurrentFilePath);
			file.delete();    
			mCurrentFilePath = null;
		}
	}

	public int getCurrentFileDuration() {
        return duration;
    }

	public String getCurrentFilePath() {
		return mCurrentFilePath;
	}
	
	public String getCurrentFileName(){
		return mCurrentFileName;
	}
}
