package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.FILTERNAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.GENDER_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INTERVIEW1_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INTERVIEW2_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INTERVIEW3_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INTERVIEW4_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INTERVIEW5_RANGE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GRADE_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVIEW1_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVIEW2_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVIEW3_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVIEW4_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVIEW5_RANGE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_LISTNAME;
import static seedu.address.logic.commands.CommandTestUtil.JOBSAPPLY_DESC_ENGINEER;
import static seedu.address.logic.commands.CommandTestUtil.KNOWNPROGLANG_DESC_JAVA;
import static seedu.address.logic.commands.CommandTestUtil.MAJOR_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NRIC_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PASTJOB_DESC_PROFESSOR;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.RACE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.SCHOOL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FILTERNAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVIEW1_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVIEW2_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVIEW3_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVIEW4_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVIEW5_RANGE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOBSAPPLY_ENGINEER;
import static seedu.address.logic.commands.CommandTestUtil.VALID_KNOWNPROGLANG_JAVA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MAJOR_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NRIC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PASTJOB_PROFESSSOR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RACE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SCHOOL_AMY;
import static seedu.address.logic.commands.FilterCommand.MESSAGE_INVALID_RANGE;
import static seedu.address.logic.commands.FilterCommand.MESSAGE_LACK_FILTERNAME;
import static seedu.address.logic.commands.FilterCommand.MESSAGE_USAGE_ALLJOB_SCREEN;
import static seedu.address.logic.commands.FilterCommand.MESSAGE_USAGE_JOB_DETAIL_SCREEN;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.model.job.JobListName;

public class FilterCommandParserTest {

    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    public void parse_invalidListName_returnsFilterCommand() {
        assertParseFailure(parser, INVALID_LISTNAME, String.format(JobListName.MESSAGE_CONSTRAINTS,
            MESSAGE_USAGE_ALLJOB_SCREEN + MESSAGE_USAGE_JOB_DETAIL_SCREEN));
    }

    @Test
    public void parse_emptyArgs_returnsFilterCommand() {
        assertParseFailure(parser, " ", String.format(MESSAGE_LACK_FILTERNAME,
            MESSAGE_USAGE_ALLJOB_SCREEN + MESSAGE_USAGE_JOB_DETAIL_SCREEN));
    }

    @Test
    public void parse_invalidValueRnge_returnsFilterCommand() {
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_GRADE_RANGE_DESC, MESSAGE_INVALID_RANGE);
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_INTERVIEW1_RANGE_DESC, MESSAGE_INVALID_RANGE);
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_INTERVIEW2_RANGE_DESC, MESSAGE_INVALID_RANGE);
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_INTERVIEW3_RANGE_DESC, MESSAGE_INVALID_RANGE);
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_INTERVIEW4_RANGE_DESC, MESSAGE_INVALID_RANGE);
        assertParseFailure(parser, FILTERNAME_DESC + INVALID_INTERVIEW5_RANGE_DESC, MESSAGE_INVALID_RANGE);
    }

    @Test
    public void parse_validArgs_returnsFilterCommand() {
        // no leading and trailing whitespaces
        FilterCommand.PredicatePersonDescriptor descriptorAmy = new FilterCommand.PredicatePersonDescriptor();
        descriptorAmy.setName(new HashSet<>(Arrays.asList(VALID_NAME_AMY.split("\\s+"))));
        descriptorAmy.setPhone(new HashSet<>(Arrays.asList(VALID_PHONE_AMY.split("\\s+"))));
        descriptorAmy.setEmail(new HashSet<>(Arrays.asList(VALID_EMAIL_AMY.split("\\s+"))));
        descriptorAmy.setRace(new HashSet<>(Arrays.asList(VALID_RACE_AMY.split("\\s+"))));
        descriptorAmy.setAddress(new HashSet<>(Arrays.asList(VALID_ADDRESS_AMY.split("\\s+"))));
        descriptorAmy.setSchool(new HashSet<>(Arrays.asList(VALID_SCHOOL_AMY.split("\\s+"))));
        descriptorAmy.setMajor(new HashSet<>(Arrays.asList(VALID_MAJOR_AMY.split("\\s+"))));
        descriptorAmy.setGender(new HashSet<>(Arrays.asList(VALID_GENDER_AMY.split("\\s+"))));
        descriptorAmy.setGrade(new HashSet<>(Arrays.asList(VALID_GRADE_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setInterviewScoreQ1(new HashSet<>(Arrays.asList(VALID_INTERVIEW1_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setInterviewScoreQ2(new HashSet<>(Arrays.asList(VALID_INTERVIEW2_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setInterviewScoreQ3(new HashSet<>(Arrays.asList(VALID_INTERVIEW3_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setInterviewScoreQ4(new HashSet<>(Arrays.asList(VALID_INTERVIEW4_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setInterviewScoreQ5(new HashSet<>(Arrays.asList(VALID_INTERVIEW5_RANGE_AMY.split("\\s+"))));
        descriptorAmy.setNric(new HashSet<>(Arrays.asList(VALID_NRIC_AMY.split("\\s+"))));
        FilterCommand expectedFilterCommand = new FilterCommand(VALID_FILTERNAME, JobListName.EMPTY, descriptorAmy);

        assertParseSuccess(parser, FILTERNAME_DESC + NAME_DESC_AMY + PHONE_DESC_AMY
            + EMAIL_DESC_AMY + NRIC_DESC_AMY + GENDER_DESC_AMY + RACE_DESC_AMY + ADDRESS_DESC_AMY
            + MAJOR_DESC_AMY + GRADE_RANGE_DESC_AMY + SCHOOL_DESC_AMY + INTERVIEW1_RANGE_DESC_AMY
            + INTERVIEW2_RANGE_DESC_AMY + INTERVIEW3_RANGE_DESC_AMY + INTERVIEW4_RANGE_DESC_AMY
            + INTERVIEW5_RANGE_DESC_AMY, expectedFilterCommand);


        // test List fields
        FilterCommand.PredicatePersonDescriptor descriptorOtherFields = new FilterCommand.PredicatePersonDescriptor();
        descriptorOtherFields.setPastJobs(new HashSet<>(Arrays.asList(VALID_PASTJOB_PROFESSSOR.split("\\s+"))));
        descriptorOtherFields.setJobsApply(new HashSet<>(
            Arrays.asList(VALID_JOBSAPPLY_ENGINEER.split("\\s+"))));
        descriptorOtherFields.setKnownProgLangs(
            new HashSet<>(Arrays.asList(VALID_KNOWNPROGLANG_JAVA.split("\\s+"))));
        expectedFilterCommand = new FilterCommand(VALID_FILTERNAME, JobListName.EMPTY, descriptorOtherFields);
        assertParseSuccess(parser, FILTERNAME_DESC + PASTJOB_DESC_PROFESSOR
            + JOBSAPPLY_DESC_ENGINEER + KNOWNPROGLANG_DESC_JAVA, expectedFilterCommand);

    }

}
