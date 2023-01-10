package com.example;

import com.example.SimpleModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("simple")
@io.quarkus.runtime.Startup()
public class SimpleProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.SimpleModel> {

    @javax.inject.Inject()
    public SimpleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        super(app, java.util.Arrays.asList(), correlations);
        activate();
    }

    public SimpleProcess() {
    }

    @Override()
    public com.example.SimpleProcessInstance createInstance(com.example.SimpleModel value) {
        return new com.example.SimpleProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.SimpleProcessInstance createInstance(java.lang.String businessKey, com.example.SimpleModel value) {
        return new com.example.SimpleProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.SimpleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.SimpleModel value) {
        return new com.example.SimpleProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.SimpleModel createModel() {
        return new com.example.SimpleModel();
    }

    public com.example.SimpleProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.SimpleModel) value);
    }

    public com.example.SimpleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.SimpleModel) value);
    }

    public com.example.SimpleProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.SimpleProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.SimpleProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.SimpleProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("simple", true);
        factory.name("simple");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_5B377DF9-5BEA-47BF-B91F-EC49D6A762B9");
        endNode1.metaData("x", 813);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 200);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode2 = factory.humanTaskNode(2);
        humanTaskNode2.name("Do Something");
        humanTaskNode2.workParameter("NodeName", "Do Something");
        humanTaskNode2.workParameter("TaskName", "Task");
        humanTaskNode2.workParameter("Skippable", "false");
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_4DD75DBD-9041-424D-BC9E-5CF3D352D1BD_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("bf8dfca8-2cdf-4e33-8669-5fc36e899881", "EXPRESSION (Task)", "java.lang.Object", "Task"), new org.jbpm.workflow.core.impl.DataDefinition("_4DD75DBD-9041-424D-BC9E-5CF3D352D1BD_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_4DD75DBD-9041-424D-BC9E-5CF3D352D1BD_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("3e44559f-e8b5-410f-bf96-f844d936269d", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_4DD75DBD-9041-424D-BC9E-5CF3D352D1BD_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode2.done();
        humanTaskNode2.metaData("UniqueId", "_4DD75DBD-9041-424D-BC9E-5CF3D352D1BD");
        humanTaskNode2.metaData("elementname", "Do Something");
        humanTaskNode2.metaData("x", 579);
        humanTaskNode2.metaData("width", 154);
        humanTaskNode2.metaData("y", 177);
        humanTaskNode2.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode3 = factory.startNode(3);
        startNode3.name("Start");
        startNode3.interrupting(true);
        startNode3.metaData("UniqueId", "_2CACACD0-4747-4774-A65B-2D69C4BF3827");
        startNode3.metaData("x", 443);
        startNode3.metaData("width", 56);
        startNode3.metaData("y", 200);
        startNode3.metaData("height", 56);
        startNode3.done();
        factory.connection(2, 1, "_FB45D91B-0DC3-4D54-8760-795CCB1FF129");
        factory.connection(3, 2, "_D1307845-71AA-434A-A3D4-5FBC94EF79E6");
        factory.validate();
        return factory.getProcess();
    }
}
