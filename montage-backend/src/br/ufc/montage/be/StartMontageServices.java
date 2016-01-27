package br.ufc.montage.be;

import javax.xml.ws.Endpoint;

public class StartMontageServices {

	public void start_mAdd(){
		String url = "http://localhost:10004/mAdd";
		I_mAdd service = new I_mAddImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mBgExec(){
		String url = "http://localhost:10005/mBgExec";
		I_mBgExec service = new I_mBgExecImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mBgModel(){
		String url = "http://localhost:10006/mBgModel";
		I_mBgModel service = new I_mBgModelImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mDiffExec(){
		String url = "http://localhost:10007/mDiffExec";
		I_mDiffExec service = new I_mDiffExecImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mFitExec(){
		String url = "http://localhost:10008/mFitExec";
		I_mFitExec service = new I_mFitExecImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mImgtbl(){
		String url = "http://localhost:10009/mImgtbl";
		I_mIgtbl service = new I_mIgtblImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mJpeg(){
		String url = "http://localhost:10010/mJpeg";
		I_mJpeg service = new I_mJpegImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	public void start_mMontageDir(){
		String url = "http://localhost:10011/mMontageDir";
		I_MontageDir service = new I_MontageDirImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public void start_mOverlaps(){
		String url = "http://localhost:10012/mOverlaps";
		I_mOverlaps service = new I_mOverlapsImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public void start_mProjexec(){
		String url = "http://localhost:10013/mProjExec";
		I_mProjExec service = new I_mProjExecImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public void start_mArchiveExec(){
		String url = "http://localhost:10014/mArchiveExec";
		I_mArchiveExec service = new I_mArchiveExecImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public void start_mArchiveList(){
		String url = "http://localhost:10015/mArchiveList";
		I_mArchiveList service = new I_mArchiveListImpl();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public static void main(String[] args) {
		StartMontageServices sms = new StartMontageServices();
		sms.startAll();
	}
	
	private void startAll() {
		start_mAdd();
		start_mBgExec();
		start_mBgModel();
		start_mDiffExec();
		start_mFitExec();
		start_mImgtbl();
		start_mJpeg();
		start_mMontageDir();
		start_mOverlaps();
		start_mProjexec();
		start_mArchiveExec();
		start_mArchiveList();
		
	}
}
