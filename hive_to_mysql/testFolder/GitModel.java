/** 
 * @Company: 北京慧点科技有限公司 | www.smartdot.com.cn
 * @Copyright 1998-2018 © Smartdot Technologies Co., Ltd. 
 */
package comm.git.model;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import comm.git.constant.GitConStants;

/** 
 * Git实体对象，收集Git操作所需要的账号、密码、资源路径等
 * @class: GitModel 
 * @date 2018年7月7日 下午2:19:56 
 * @author 张尧(himo.zhang) | mail:zhangyy@smartdot.com
 * @version 1.0 - 2018年7月7日
 * @see  
 */
public class GitModel {
	//本地Git仓库工作空间（平台服务器对应的git workspace路径）
	private String localGitWorkSpacePath;
	//本地资源名称（项目名称）
	private String localRepoName;
	//本地Git资源路径（平台服务器对应的git workspace路径）
	private String localRepoPath ;
	//本地Git资源.git配置文件夹路径（默认为：localRepoPath/.git）
	private String localRepoGitConfigPath ;
	//远程GIT服务器资源URL地址
	private String remoteGitRepoUrl;
	//远程GIT服务器分支名称（默认为master）
	private String branchName = GitConStants.DEFAULT_BRANCH_NAME;
	//远程GIT服务器账号名称
	private String gitAccountName;
	//远程GIT服务器密码
	private String gitAccountPassword;
	
	/**
	 * @return the localRepoName
	 */
	public String getLocalRepoName() {
		return localRepoName;
	}
	/**
	 * @param localRepoName the localRepoName to set
	 */
	public void setLocalRepoName(String localRepoName) {
		this.localRepoName = localRepoName;
	}
	/**
	 * 本地Git仓库工作空间（平台服务器对应的git workspace路径）
	 * @return the localGitWorkSpacePath
	 */
	public String getLocalGitWorkSpacePath() {
		return localGitWorkSpacePath;
	}
	/**
	 * 设置 - 本地Git仓库工作空间（平台服务器对应的git workspace路径）
	 * @param localGitWorkSpacePath the localGitWorkSpacePath to set
	 */
	public void setLocalGitWorkSpacePath(String localGitWorkSpacePath) {
		this.localGitWorkSpacePath = localGitWorkSpacePath;
	}
	/**
	 * 本地Git资源路径（平台服务器对应的git workspace路径）
	 * @return the localRepoPath
	 */
	public String getLocalRepoPath() {
		if(StringUtils.isBlank(localRepoPath)){
			return getLocalGitWorkSpacePath()+File.separator+getLocalRepoName();
		}
		return localRepoPath;
	}
	/**
	 * 设置 - 本地Git资源路径（平台服务器对应的git workspace路径）
	 * @param localRepoPath the localRepoPath to set
	 */
	public void setLocalRepoPath(String localRepoPath) {
		this.localRepoPath = localRepoPath;
	}
	/**
	 * 本地Git资源.git配置文件夹路径（默认为：localRepoPath/.git）
	 * @return the localRepoGitConfigPath
	 */
	public String getLocalRepoGitConfigPath() {
		if(StringUtils.isBlank(localRepoGitConfigPath)){
			return getLocalRepoPath()+File.separator+GitConStants.GIT_CONFFIG_FILE_NAME;
		}
		return localRepoGitConfigPath;
	}
	/**
	 * 设置 - 本地Git资源.git配置文件夹路径（默认为：localRepoPath/.git）
	 * @param localRepoGitConfigPath the localRepoGitConfigPath to set
	 */
	public void setLocalRepoGitConfigPath(String localRepoGitConfigPath) {
		this.localRepoGitConfigPath = localRepoGitConfigPath;
	}
	/**
	 * 远程GIT服务器资源URL地址
	 * @return the remoteGitRepoUrl
	 */
	public String getRemoteGitRepoUrl() {
		return remoteGitRepoUrl;
	}
	/**
	 * 设置 - 远程GIT服务器资源URL地址
	 * @param remoteGitRepoUrl the remoteGitRepoUrl to set
	 */
	public void setRemoteGitRepoUrl(String remoteGitRepoUrl) {
		this.remoteGitRepoUrl = remoteGitRepoUrl;
	}
	/**
	 * 远程GIT服务器分支名称（默认为master）
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * 设置 - 远程GIT服务器分支名称（默认为master）
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * 远程GIT服务器账号名称
	 * @return the gitAccountName
	 */
	public String getGitAccountName() {
		return gitAccountName;
	}
	/**
	 * 设置 - 远程GIT服务器账号名称
	 * @param gitAccountName the gitAccountName to set
	 */
	public void setGitAccountName(String gitAccountName) {
		this.gitAccountName = gitAccountName;
	}
	/**
	 * 远程GIT服务器密码
	 * @return the gitAccountPassword
	 */
	public String getGitAccountPassword() {
		return gitAccountPassword;
	}
	/**设置 - 远程GIT服务器密码
	 * @param gitAccountPassword the gitAccountPassword to set
	 */
	public void setGitAccountPassword(String gitAccountPassword) {
		this.gitAccountPassword = gitAccountPassword;
	}
	
	
}
