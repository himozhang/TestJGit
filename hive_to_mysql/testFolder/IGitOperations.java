/** 
 * @Company: 上海理想信息产业(集团)有限公司 | www.ideal.cn
 * @Copyright 2018 © ShangHai Ideal Technologies Co., Ltd. 
 */
package comm.git;

import java.util.List;

import org.eclipse.jgit.lib.Repository;

import comm.git.model.GitModel;
import comm.git.model.JsonResult;
import comm.git.model.LogModel;

/** 
 * Git操作类定义
 * @class: IGitOperations 
 * @date 2018年7月7日 下午1:54:20 
 * @author 张尧(himo.zhang) | mail:ieal_tom@163.com
 * @version 1.0 - 2018年7月7日
 * @see  
 */
public interface IGitOperations {

	/***
	 * 创建新仓库
	 * @param localReopPath
	 * @return  Repository
	 */
	public Repository createNewRepository(String localReopPath);
	
	/**
	 * 克隆远程GIT服务器资源到服务器，并返回成功信息
	 * @param remoteRepoGitUrl 远程Git URL
	 * @param localRepoPath本地Git资源路径
	 * @return  String 成功或失败信息
	 */
	public JsonResult cloneRepository(String remoteRepoGitUrl,String localRepoPath);
	
	/**
	 * 从服务器更新资源，并指定分支名称
	 * @param branchName
	 * @return   String 成功或失败信息
	 */
	public JsonResult pull(String branchName);
	
	/**
	 * 从服务器更新资源，并使用默认分支：master
	 * @param branchName
	 * @return   String 成功或失败信息
	 */
	public JsonResult pull();
	
	/**
	 * 删除GIT服务器文件
	 * @param gitModel
	 * @param filePath
	 * @return  
	 * String
	 */
	public JsonResult removeFile(GitModel gitModel,String filePath);
	
	/**
	 * 创建本地存储，在PULL有冲突时候，先将本地修改存储
	 * @return   String 成功或失败信息
	 */
	public String stashCreate();
	
	/**
	 * 修改还原
	 * @return   String 成功或失败信息
	 */
	public String stashApply();
	
	/**
     * 查看所有存储的修改记录
     * return List
     */
    public  List<LogModel> stashList();
    
    /**
     * 提交资源到本地资源库（平台服务器）
     * @param gitModel
     * @param fileNames 文件集合(使用“,”进行拼接)
     * @param message 本次提交描述
     * @return   String
     */
    public JsonResult commit(GitModel gitModel,String fileNames,String message);
    /**
     * 推送本地修改到GIT服务器
     * @param gitModel
     * @return  
     * String
     */
    public JsonResult push(GitModel gitModel);
    
    /**
     * 提交并推送资源
     * @param fileNames
     * @param message
     * @return  
     * String
     */
    public JsonResult commitAndPush(String fileNames,String message);
	
    /**
     * 列表展现git服务器上资源列表
     * @param localRepoConfigPath /.git文件夹路径
     * @return   List<String>
     */
    public List<String> remoteRepoFileList(String localRepoConfigPath);
    
    /**
     * 列表展现日志
     * @param localRepoConfigPath
     * @return  
     * List<LogModel>
     */
    public List<LogModel> logs(String localRepoConfigPath);
		
}
