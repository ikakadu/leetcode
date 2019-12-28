package com.it.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author Borris.W.Q.Bi
 *@DateTime 2019/11/19 14:17
 *@Description 商户中心相关枚举类
 *@Modify who       when         why
 *------------------------------------
 */
public enum MchtCenEnum {
    //大类型：商户
    Mcht("商户"),
    //中类型
    MchtAuditFlowState(Mcht, "商户审核流程状态"),
    MchtAuditResult(Mcht, "运营审核结果"),
    MchtAuditState(Mcht, "审核状态"),
    MchtAuditType(Mcht, "审核类型"),
    MchtFlowState(Mcht, "流程状态"),
    MchtLegalInfType(Mcht, "商户法务认证信息类型"),
    MchtState(Mcht, "商户状态"),
    MchtType(Mcht, "商户类型"),
    MchtOperatorState(Mcht, "操作员状态"),
    MchtProgressState(Mcht, "进度状态"),
    MchtTodoType(Mcht, "待办事项类型"),
    MchtDraftState(Mcht, "商户草稿状态"),
    //用户记录修改明细的from table和附件doc表的relate table
    MchtInfEntityType(Mcht,"商户信息实体标志"),
    //小类型
    //商户状态
    Register(MchtState, "已注册", "01"),
    Pending(MchtState, "待审核", "02"),
    ContractSigning(MchtState, "协议待同意", "03"),
    Validated(MchtState, "有效", "04"),
    Frozen(MchtState, "已冻结", "05"),
    PendingClose(MchtState, "预关闭", "06"),
    Closed(MchtState, "已关闭", "07"),
    Deleted(MchtState, "已删除", "08"),
    //商户流程状态
    Normal(MchtFlowState, "正常商户", "0"),
    InFlow(MchtFlowState, "流程中商户", "1"),
    //商户审核类型
    CreateAudit(MchtAuditType, "进件审核", "01"),
    MchtModifyAudit(MchtAuditType, "商户变更审核", "02"),
    OperModifyAudit(MchtAuditType, "运营变更审核", "03"),
    FreezeAudit(MchtAuditType, "冻结审核", "04"),
    DeleteAudit(MchtAuditType, "删除审核", "05"),
    CloseAudit(MchtAuditType, "关闭审核", "06"),
    AdminChangeAudit(MchtAuditType, "超管变更审核", "07"),
    UserFreezeAudit(MchtAuditType, "操作员冻结审核", "08"),
    //流程审核状态
    Auditing(MchtAuditState, "审核中", "01"),
    AuditPass(MchtAuditState, "审核通过", "02"),
    AuditReject(MchtAuditState, "审核驳回", "03"),
    //运营审核结果
    OperAuditPass(MchtAuditResult, "审核通过", "01"),
    OperAuditReject(MchtAuditResult, "审核驳回", "02"),
    //流程状态枚举
    FlowProccessing(MchtAuditFlowState, "进行中", "01"),
    FlowCompleted(MchtAuditFlowState, "已结束", "02"),
    //法务信息类型
    LegalRepresentative(MchtLegalInfType, "法人代表", "01"),
    Beneficiary(MchtLegalInfType, "受益人", "02"),
    AuthorizedPerson(MchtLegalInfType, "授权人", "03"),
    OtherCerts(MchtLegalInfType, "其他证件", "04"),
    //商户类型
    MainlandChinaIndividual(MchtType, "大陆个人", "01"),
    MainlandChinaEnterprise(MchtType, "大陆企业", "02"),
    HongKongIndividual(MchtType, "香港个人", "03"),
    HongKongEnterprise(MchtType, "香港企业", "04"),
    OtherIndividual(MchtType, "其他国家或地区个人", "05"),
    OtherEnterprise(MchtType, "其他国家或地区企业", "06"),
    //操作员状态
    MchtOperatorValidated(MchtOperatorState, "有效", "01"),
    MchtOperatorFrozen(MchtOperatorState, "冻结", "02"),
    MchtOperatorInvalid(MchtOperatorState, "无效", "03"),
    //进度状态
    MchtProgressNotContacted(MchtProgressState, "未联系"),
    MchtProgressContacted(MchtProgressState, "已联系"),
    //待办事项类型
    MchtTodoTypeInf(MchtTodoType, "待办事项类型-实名认证", "001"),
    MchtTodoTypeTrade(MchtTodoType, "待办事项类型-交易相关", "002"),
    //待办事项二级类型
    MchtTodoTypeInfMailValidate(MchtTodoTypeInf, "信息补充-验证邮箱", "001001"),
    MchtTodoTypeInfTradePw(MchtTodoTypeInf, "信息补充-设置交易密码", "001002"),
    MchtTodoTypeInfIdentify(MchtTodoTypeInf, "信息补充-实名认证", "001003"),
    MchtTodoTypeInfBankCard(MchtTodoTypeInf, "信息补充-添加提现卡", "001004"),
    MchtTodoTypeInfShop(MchtTodoTypeInf, "信息补充-添加店铺", "001005"),
    //商户草稿状态
    // 01修改中；02审核中；03协议待同意（进件审核已通过，但商户未同意协议）；
    // 04黑名单不通过（无法再次提交审核）；
    // 05关闭（即 进件/变更 流程已完成）
    // 06已删除
    MchtDraftEditing(MchtDraftState, "修改中", "01"),
    MchtDraftInFlow(MchtDraftState, "审核中", "02"),
    MchtDraftInProtocal(MchtDraftState, "协议待同意", "03"),
    MchtDraftBlackListBan(MchtDraftState, "黑名单不通过", "04"),
    MchtDraftClose(MchtDraftState, "关闭", "05"),
    MchtDraftDeleted(MchtDraftState, "已删除", "06"),
    //用户记录修改明细的from table和附件doc表的relate table
    MchtInfBase(MchtInfEntityType,"Base","Base"),
    MchtInfEnterprise(MchtInfEntityType,"InfEnterprise","InfEnterprise"),
    MchtInfIndividual(MchtInfEntityType,"InfIndividual","InfIndividual"),
    MchtInfLegal(MchtInfEntityType,"InfLegal","InfLegal"),

    ;

    MchtCenEnum(String name) {
        this.name = name;
        this.childList = new ArrayList<MchtCenEnum>();
    }

    MchtCenEnum(MchtCenEnum parent, String name) {
        this.parent = parent;
        this.name = name;
        this.childList = new ArrayList<MchtCenEnum>();
        parent.childList.add(this);
    }

    MchtCenEnum(MchtCenEnum parent, String name, String value) {
        this.parent = parent;
        this.value = value;
        this.name = name;
        this.childList = new ArrayList<MchtCenEnum>();
        parent.childList.add(this);
    }

    /**
     * Borris.W.Q.Bi 2019/11/20 14:33
     * 通过value，父级枚举找name
     */
    public static MchtCenEnum findNameByValue(MchtCenEnum parent, String value) {
        List<MchtCenEnum> l = parent.getChildList();
        return l.stream().filter(e -> e.value.equals(value)).findFirst().get();
    }

    /**
     * Borris.W.Q.Bi 2019/11/20 14:33
     * 通过name，父级枚举找value
     */
    public static MchtCenEnum findValueByName(MchtCenEnum parent, String name) {
        List<MchtCenEnum> l = parent.getChildList();
        return l.stream().filter(e -> e.name.equals(name)).findFirst().get();
    }

    private MchtCenEnum parent;
    private String value;
    private String name;
    private List<MchtCenEnum> childList;

    public MchtCenEnum getParent() {
        return parent;
    }

    public void setParent(MchtCenEnum parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MchtCenEnum> getChildList() {
        return childList;
    }

    public void setChildList(List<MchtCenEnum> childList) {
        this.childList = childList;
    }
}