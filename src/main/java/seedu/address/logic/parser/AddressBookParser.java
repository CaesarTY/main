package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_COMMAND_CANNOT_USE;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddListToJobCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ClearFilterCommand;
import seedu.address.logic.commands.ClearInterviewsCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CreateJobCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteFilterCommand;
import seedu.address.logic.commands.DeleteJobCommand;
import seedu.address.logic.commands.DisplayJobCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.commands.GenerateAnalyticsCommand;
import seedu.address.logic.commands.GenerateInterviewsCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ImportResumesCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MovePeopleCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RemoveFromListCommand;
import seedu.address.logic.commands.SetBlockOutDatesCommand;
import seedu.address.logic.commands.SetMaxInterviewsADayCommand;
import seedu.address.logic.commands.ShowInterviewsCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput, boolean isAllJobScreen) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new AddCommandParser().parse(arguments);

        case AddCommand.COMMAND_ALIAS:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new AddCommandParser().parse(arguments);

        case ImportResumesCommand.COMMAND_WORD:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new ImportResumesCommandParser().parse(arguments);

        case ImportResumesCommand.COMMAND_ALIAS:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new ImportResumesCommandParser().parse(arguments);

        case CreateJobCommand.COMMAND_WORD:
            return new CreateJobCommandParser().parse(arguments);

        case CreateJobCommand.COMMAND_ALIAS:
            return new CreateJobCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new EditCommandParser().parse(arguments);

        case EditCommand.COMMAND_ALIAS:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new EditCommandParser().parse(arguments);

        case DeleteFilterCommand.COMMAND_WORD:
            return new DeleteFilterCommandParser().parse(arguments);

        case DeleteFilterCommand.COMMAND_ALIAS:
            return new DeleteFilterCommandParser().parse(arguments);

        case ClearFilterCommand.COMMAND_WORD:
            return new ClearFilterCommandParser().parse(arguments);

        case ClearFilterCommand.COMMAND_ALIAS:
            return new ClearFilterCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new DeleteCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_ALIAS:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new ClearCommand();

        case ClearCommand.COMMAND_ALIAS:
            if (!isAllJobScreen) {
                throw new ParseException(MESSAGE_COMMAND_CANNOT_USE);
            }
            return new ClearCommand();

        case FilterCommand.COMMAND_WORD:
            return new FilterCommandParser().parse(arguments);

        case FilterCommand.COMMAND_ALIAS:
            return new FilterCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ListCommand.COMMAND_ALIAS:
            return new ListCommand();

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case HistoryCommand.COMMAND_ALIAS:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case ExitCommand.COMMAND_ALIAS:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case HelpCommand.COMMAND_ALIAS:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case UndoCommand.COMMAND_ALIAS:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        case RedoCommand.COMMAND_ALIAS:
            return new RedoCommand();

        case GenerateInterviewsCommand.COMMAND_WORD:
            return new GenerateInterviewsCommand();

        case ShowInterviewsCommand.COMMAND_WORD:
            return new ShowInterviewsCommand();

        case SetMaxInterviewsADayCommand.COMMAND_WORD:
            return new SetMaxInterviewsADayCommandParser().parse(arguments);

        case ClearInterviewsCommand.COMMAND_WORD:
            return new ClearInterviewsCommand();

        case GenerateAnalyticsCommand.COMMAND_WORD:
            return new AnalyticsCommandParser().parse(arguments);

        case SetBlockOutDatesCommand.COMMAND_WORD:
            return new SetBlockOutDatesCommandParser().parse(arguments);

        case DisplayJobCommand.COMMAND_WORD:
            return new DisplayJobCommandParser().parse(arguments);

        case DisplayJobCommand.COMMAND_ALIAS:
            return new DisplayJobCommandParser().parse(arguments);

        case MovePeopleCommand.COMMAND_WORD:
            return new MovePeopleCommandParser().parse(arguments);

        case MovePeopleCommand.COMMAND_ALIAS:
            return new MovePeopleCommandParser().parse(arguments);

        case DeleteJobCommand.COMMAND_WORD:
            return new DeleteJobCommandParser().parse(arguments);

        case DeleteJobCommand.COMMAND_ALIAS:
            return new DeleteJobCommandParser().parse(arguments);

        case AddListToJobCommand.COMMAND_WORD:
            return new AddListToJobCommandParser().parse(arguments);

        case AddListToJobCommand.COMMAND_ALIAS:
            return new AddListToJobCommandParser().parse(arguments);

        case RemoveFromListCommand.COMMAND_WORD:
            return new RemoveFromListCommandParser().parse(arguments);

        case RemoveFromListCommand.COMMAND_ALIAS:
            return new RemoveFromListCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
