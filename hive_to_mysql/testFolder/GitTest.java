/** 
 * @Company: 上海理想信息产业(集团)有限公司 | www.ideal.cn
 * @Copyright 2018 © ShangHai Ideal Technologies Co., Ltd. 
 */
package comm.git.test;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import comm.git.GitFactory;
import comm.git.constant.GitConStants;
import comm.git.model.GitModel;
import comm.git.model.JsonResult;

/** 
 * Git测试
 * @class: GitTest 
 * @date 2018年7月7日 下午3:29:17 
 * @author 张尧(himo.zhang) | mail:zhangyy@smartdot.com
 * @version 1.0 - 2018年7月7日
 * @see  
 */
public class GitTest {
	
	final static Logger logger = LoggerFactory.getLogger(GitTest.class);
	
	public static void main(String[] args) {
		GitModel gm= new GitModel();
		gm.setLocalRepoPath("/Volumes/workspace/02-codesources/Java/workspace/Git/TestJGit");
		gm.setRemoteGitRepoUrl("https://github.com/himozhang/TestJGit.git");
		gm.setGitAccountName("himozhang");
		gm.setGitAccountPassword("zhang110");
		//1、在所有操作执行前，需要先判断资源是否存在，如果不存在则需要自动先从远程GIT上抓取资源
		if(!checkReop(gm.getLocalRepoGitConfigPath())){
			logger.error("本地资源不存在， 正在创建资源，请稍后...");
			JsonResult jr1 = GitFactory.cloneRepository(gm.getRemoteGitRepoUrl(), gm.getLocalRepoPath(),gm.getGitAccountName(),gm.getGitAccountPassword());
			logger.info("--> 1、在所有操作执行前，需要先判断资源是否存在，如果不存在则需要自动先从远程GIT上抓取资源 : "+jr1.getMsg());
		}else{
			logger.error("--> 1、在所有操作执行前，需要先判断资源是否存在，如果不存在则需要自动先从远程GIT上抓取资源 : 本地资源已存在！");
		}
		
		//2、pull,如果git服务器有更新（修改、删除），则会同步到本地git仓库
		JsonResult jr2 = GitFactory.pull(gm.getLocalRepoGitConfigPath(), gm.getBranchName());
		logger.info("--> 2、pull : "+jr2.getMsg());
		
//		//2、用户修改文件后，选择上传更新后的文件
//		String fileNames = "JGitTest.txt;hive_to_mysql/testFolder/GitModel.java";
//		JsonResult jr3 = GitFactory.commitAndPush(gm,  "测试多个文件修改，并commit和push操作。。");
//		logger.info("--> 2、用户修改文件后，选择上传更新后的文件 : "+jr3.getMsg());
	}
	
	/**
	 * 检查本地资源是否存在
	 * @param localRepoPath
	 * @return  
	 * boolean
	 */
	public static boolean checkReop(String localRepoPath){
		if(GitFactory.getRepository(localRepoPath)!=null){
			return true;
		}
		return false;
	}
	
	
	
	
}
